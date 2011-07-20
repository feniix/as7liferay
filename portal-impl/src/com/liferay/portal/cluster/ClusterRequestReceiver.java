/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.cluster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.cluster.Address;
import com.liferay.portal.kernel.cluster.ClusterException;
import com.liferay.portal.kernel.cluster.ClusterMessageType;
import com.liferay.portal.kernel.cluster.ClusterNode;
import com.liferay.portal.kernel.cluster.ClusterNodeResponse;
import com.liferay.portal.kernel.cluster.ClusterRequest;
import com.liferay.portal.kernel.cluster.FutureClusterResponses;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodHandler;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jgroups.Channel;
import org.jgroups.ChannelException;
import org.jgroups.Message;
import org.jgroups.View;

/**
 * @author Michael C. Han
 * @author Tina Tian
 */
public class ClusterRequestReceiver extends BaseReceiver {

	public ClusterRequestReceiver(ClusterExecutorImpl clusterExecutorImpl) {
		_clusterExecutorImpl = clusterExecutorImpl;
	}

	public void receive(Message message) {
		org.jgroups.Address sourceAddress = message.getSrc();

		Channel controlChannel = _clusterExecutorImpl.getControlChannel();

		org.jgroups.Address localAddress = controlChannel.getAddress();

		Object obj = message.getObject();

		if (obj == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("Message content is null");
			}

			return;
		}

		if (localAddress.equals(sourceAddress)) {
			boolean isProcessed = processLocalMessage(obj, sourceAddress);

			if (isProcessed) {
				return;
			}
		}

		if (obj instanceof ClusterRequest) {
			ClusterRequest clusterRequest = (ClusterRequest)obj;

			processClusterRequest(clusterRequest, sourceAddress, localAddress);
		}
		else if (obj instanceof ClusterNodeResponse) {
			ClusterNodeResponse clusterNodeResponse = (ClusterNodeResponse)obj;

			processClusterResponse(
				clusterNodeResponse, sourceAddress, localAddress);
		}
		else {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to process message content of type " +
						obj.getClass().getName());
			}
		}
	}

	public void viewAccepted(View view) {
		if (_log.isDebugEnabled()) {
			_log.debug("Accepted view " + view);
		}

		if (_lastView == null) {
			_lastView = view;

			return;
		}

		List<Address> departAddresses = getDepartAddresses(view);

		_lastView = view;

		if (departAddresses.isEmpty()) {
			return;
		}

		_clusterExecutorImpl.memberRemoved(departAddresses);
	}

	protected Object invoke(
			String servletContextName, MethodHandler methodHandler)
		throws Exception {

		if (servletContextName == null) {
			return methodHandler.invoke(true);
		}

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			ClassLoader classLoader =
				(ClassLoader)PortletBeanLocatorUtil.locate(
					servletContextName, "portletClassLoader");

			currentThread.setContextClassLoader(classLoader);

			return methodHandler.invoke(true);
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	protected List<Address> getDepartAddresses(View view) {
		List<Address> departAddresses = new ArrayList<Address>();

		List<org.jgroups.Address> jGroupsAddresses = view.getMembers();
		List<org.jgroups.Address> lastJGroupsAddresses =
			_lastView.getMembers();

		List<org.jgroups.Address> tempAddresses =
			new ArrayList<org.jgroups.Address>(jGroupsAddresses.size());

		tempAddresses.addAll(jGroupsAddresses);

		List<org.jgroups.Address> lastAddresses =
			new ArrayList<org.jgroups.Address>(lastJGroupsAddresses.size());

		lastAddresses.addAll(lastJGroupsAddresses);

		tempAddresses.retainAll(lastJGroupsAddresses);
		lastAddresses.removeAll(tempAddresses);

		if (!lastAddresses.isEmpty()) {
			Iterator<org.jgroups.Address> itr = lastAddresses.iterator();

			while (itr.hasNext()) {
				departAddresses.add(new AddressImpl(itr.next()));
			}
		}

		return departAddresses;
	}

	protected void processClusterRequest(
		ClusterRequest clusterRequest, org.jgroups.Address sourceAddress,
		org.jgroups.Address localAddress) {

		ClusterMessageType clusterMessageType =
			clusterRequest.getClusterMessageType();

		ClusterNodeResponse clusterNodeResponse = new ClusterNodeResponse();

		try {
			ClusterNode localClusterNode =
				_clusterExecutorImpl.getLocalClusterNode();

			clusterNodeResponse.setClusterNode(localClusterNode);
		}
		catch (Exception e) {
			clusterNodeResponse.setException(e);
		}

		if (clusterMessageType.equals(ClusterMessageType.NOTIFY) ||
			clusterMessageType.equals(ClusterMessageType.UPDATE)) {

			ClusterNode originatingClusterNode =
				clusterRequest.getOriginatingClusterNode();

			if (originatingClusterNode != null) {
				_clusterExecutorImpl.memberJoined(
					new AddressImpl(sourceAddress), originatingClusterNode);

				clusterNodeResponse.setClusterMessageType(clusterMessageType);
			}
			else {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Content of notify message does not contain cluster " +
							"node information");
				}

				return;
			}
		}
		else {
			clusterNodeResponse.setClusterMessageType(
				ClusterMessageType.EXECUTE);
			clusterNodeResponse.setMulticast(clusterRequest.isMulticast());
			clusterNodeResponse.setUuid(clusterRequest.getUuid());

			MethodHandler methodHandler = clusterRequest.getMethodHandler();

			if (methodHandler != null) {
				try {
					ClusterInvokeThreadLocal.setEnabled(false);

					Object returnValue = invoke(
						clusterRequest.getServletContextName(), methodHandler);

					if (returnValue instanceof Serializable) {
						clusterNodeResponse.setResult(returnValue);
					}
					else if (returnValue != null) {
						clusterNodeResponse.setException(
							new ClusterException(
								"Return value is not serializable"));
					}
				}
				catch (Exception e) {
					clusterNodeResponse.setException(e);

					_log.error("Failed to invoke method " + methodHandler, e);
				}
				finally {
					ClusterInvokeThreadLocal.setEnabled(true);
				}
			}
			else {
				clusterNodeResponse.setException(
					new ClusterException(
						"Payload is not of type " +
							MethodHandler.class.getName()));
			}
		}

		Channel controlChannel = _clusterExecutorImpl.getControlChannel();

		try {
			controlChannel.send(
				sourceAddress, localAddress, clusterNodeResponse);
		}
		catch (ChannelException ce) {
			_log.error(
				"Unable to send response message " + clusterNodeResponse, ce);
		}
		catch (Throwable t) {
			_log.error(t, t);
		}
	}

	protected void processClusterResponse(
		ClusterNodeResponse clusterNodeResponse,
		org.jgroups.Address sourceAddress, org.jgroups.Address localAddress) {

		ClusterMessageType clusterMessageType =
			clusterNodeResponse.getClusterMessageType();

		if (clusterMessageType.equals(ClusterMessageType.NOTIFY) ||
			clusterMessageType.equals(ClusterMessageType.UPDATE)) {

			ClusterNode clusterNode = clusterNodeResponse.getClusterNode();

			if (clusterNode != null) {
				Address joinAddress = new AddressImpl(sourceAddress);

				_clusterExecutorImpl.memberJoined(joinAddress, clusterNode);
			}
			else {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Response of notify message does not contain cluster " +
							"node information");
				}
			}

			return;
		}

		String uuid = clusterNodeResponse.getUuid();

		FutureClusterResponses futureClusterResponses =
			_clusterExecutorImpl.getExecutionResults(uuid);

		if (futureClusterResponses == null) {
			if (_log.isInfoEnabled()) {
				_log.info("Unable to find response container for " + uuid);
			}

			return;
		}

		Address address = new AddressImpl(sourceAddress);

		if (futureClusterResponses.expectsReply(address)) {
			futureClusterResponses.addClusterNodeResponse(clusterNodeResponse);
		}
		else {
			if (_log.isWarnEnabled()) {
				_log.warn("Unknown uuid " + uuid + " from " + sourceAddress);
			}
		}
	}

	protected boolean processLocalMessage(
		Object message, org.jgroups.Address sourceAddress) {

		if (message instanceof ClusterRequest) {
			ClusterRequest clusterRequest = (ClusterRequest)message;

			if (clusterRequest.isSkipLocal()) {
				return true;
			}

			ClusterMessageType clusterMessageType =
				clusterRequest.getClusterMessageType();

			if (clusterMessageType.equals(ClusterMessageType.NOTIFY) ||
				clusterMessageType.equals(ClusterMessageType.UPDATE)) {

				ClusterNode originatingClusterNode =
					clusterRequest.getOriginatingClusterNode();

				if (originatingClusterNode != null) {
					Address joinAddress = new AddressImpl(sourceAddress);

					_clusterExecutorImpl.memberJoined(
						joinAddress, originatingClusterNode);
				}
				else {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Content of notify message does not contain " +
								"cluster node information");
					}
				}

				return true;
			}
		}

		if (_clusterExecutorImpl.isShortcutLocalMethod()) {
			return true;
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ClusterRequestReceiver.class);

	private ClusterExecutorImpl _clusterExecutorImpl;
	private View _lastView;

}
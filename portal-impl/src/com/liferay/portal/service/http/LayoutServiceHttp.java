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

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.LayoutServiceUtil;

/**
 * <p>
 * This class provides a HTTP utility for the
 * {@link com.liferay.portal.service.LayoutServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link com.liferay.portal.security.auth.HttpPrincipal} parameter.
 * </p>
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutServiceSoap
 * @see       com.liferay.portal.security.auth.HttpPrincipal
 * @see       com.liferay.portal.service.LayoutServiceUtil
 * @generated
 */
public class LayoutServiceHttp {
	public static com.liferay.portal.model.Layout addLayout(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"addLayout", long.class, boolean.class, long.class,
					java.util.Map.class, java.util.Map.class,
					java.lang.String.class, java.lang.String.class,
					boolean.class, java.lang.String.class,
					com.liferay.portal.service.ServiceContext.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, parentLayoutId, localeNamesMap,
					localeTitlesMap, description, type, hidden, friendlyURL,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout addLayout(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long parentLayoutId, java.lang.String name, java.lang.String title,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"addLayout", long.class, boolean.class, long.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					boolean.class, java.lang.String.class,
					com.liferay.portal.service.ServiceContext.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, parentLayoutId, name, title, description,
					type, hidden, friendlyURL, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteLayout(HttpPrincipal httpPrincipal, long plid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"deleteLayout", long.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteLayout(HttpPrincipal httpPrincipal, long groupId,
		boolean privateLayout, long layoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"deleteLayout", long.class, boolean.class, long.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static byte[] exportLayouts(HttpPrincipal httpPrincipal,
		long groupId, boolean privateLayout, long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"exportLayouts", long.class, boolean.class, long[].class,
					java.util.Map.class, java.util.Date.class,
					java.util.Date.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutIds, parameterMap, startDate, endDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (byte[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static byte[] exportLayouts(HttpPrincipal httpPrincipal,
		long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"exportLayouts", long.class, boolean.class,
					java.util.Map.class, java.util.Date.class,
					java.util.Date.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, parameterMap, startDate, endDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (byte[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.io.File exportLayoutsAsFile(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"exportLayoutsAsFile", long.class, boolean.class,
					long[].class, java.util.Map.class, java.util.Date.class,
					java.util.Date.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutIds, parameterMap, startDate, endDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.io.File)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static byte[] exportPortletInfo(HttpPrincipal httpPrincipal,
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"exportPortletInfo", long.class, long.class,
					java.lang.String.class, java.util.Map.class,
					java.util.Date.class, java.util.Date.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid,
					groupId, portletId, parameterMap, startDate, endDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (byte[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.io.File exportPortletInfoAsFile(
		HttpPrincipal httpPrincipal, long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"exportPortletInfoAsFile", long.class, long.class,
					java.lang.String.class, java.util.Map.class,
					java.util.Date.class, java.util.Date.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid,
					groupId, portletId, parameterMap, startDate, endDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.io.File)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getLayoutName(HttpPrincipal httpPrincipal,
		long groupId, boolean privateLayout, long layoutId,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"getLayoutName", long.class, boolean.class, long.class,
					java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, languageId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.LayoutReference[] getLayoutReferences(
		HttpPrincipal httpPrincipal, long companyId,
		java.lang.String portletId, java.lang.String preferencesKey,
		java.lang.String preferencesValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"getLayoutReferences", long.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, portletId, preferencesKey, preferencesValue);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.LayoutReference[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void importLayouts(HttpPrincipal httpPrincipal, long groupId,
		boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"importLayouts", long.class, boolean.class,
					java.util.Map.class, byte[].class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, parameterMap, bytes);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void importLayouts(HttpPrincipal httpPrincipal, long groupId,
		boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"importLayouts", long.class, boolean.class,
					java.util.Map.class, java.io.File.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, parameterMap, file);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void importLayouts(HttpPrincipal httpPrincipal, long groupId,
		boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"importLayouts", long.class, boolean.class,
					java.util.Map.class, java.io.InputStream.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, parameterMap, is);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void importPortletInfo(HttpPrincipal httpPrincipal,
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"importPortletInfo", long.class, long.class,
					java.lang.String.class, java.util.Map.class,
					java.io.File.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid,
					groupId, portletId, parameterMap, file);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void importPortletInfo(HttpPrincipal httpPrincipal,
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"importPortletInfo", long.class, long.class,
					java.lang.String.class, java.util.Map.class,
					java.io.InputStream.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid,
					groupId, portletId, parameterMap, is);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void schedulePublishToLive(HttpPrincipal httpPrincipal,
		long sourceGroupId, long targetGroupId, boolean privateLayout,
		java.util.Map<java.lang.Long, java.lang.Boolean> layoutIdMap,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.lang.String scope, java.util.Date startDate,
		java.util.Date endDate, java.lang.String groupName,
		java.lang.String cronText, java.util.Date schedulerStartDate,
		java.util.Date schedulerEndDate, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"schedulePublishToLive", long.class, long.class,
					boolean.class, java.util.Map.class, java.util.Map.class,
					java.lang.String.class, java.util.Date.class,
					java.util.Date.class, java.lang.String.class,
					java.lang.String.class, java.util.Date.class,
					java.util.Date.class, java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					sourceGroupId, targetGroupId, privateLayout, layoutIdMap,
					parameterMap, scope, startDate, endDate, groupName,
					cronText, schedulerStartDate, schedulerEndDate, description);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void schedulePublishToRemote(HttpPrincipal httpPrincipal,
		long sourceGroupId, boolean privateLayout,
		java.util.Map<java.lang.Long, java.lang.Boolean> layoutIdMap,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.lang.String remoteAddress, int remotePort,
		boolean secureConnection, long remoteGroupId,
		boolean remotePrivateLayout, java.util.Date startDate,
		java.util.Date endDate, java.lang.String groupName,
		java.lang.String cronText, java.util.Date schedulerStartDate,
		java.util.Date schedulerEndDate, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"schedulePublishToRemote", long.class, boolean.class,
					java.util.Map.class, java.util.Map.class,
					java.lang.String.class, int.class, boolean.class,
					long.class, boolean.class, java.util.Date.class,
					java.util.Date.class, java.lang.String.class,
					java.lang.String.class, java.util.Date.class,
					java.util.Date.class, java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					sourceGroupId, privateLayout, layoutIdMap, parameterMap,
					remoteAddress, remotePort, secureConnection, remoteGroupId,
					remotePrivateLayout, startDate, endDate, groupName,
					cronText, schedulerStartDate, schedulerEndDate, description);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void setLayouts(HttpPrincipal httpPrincipal, long groupId,
		boolean privateLayout, long parentLayoutId, long[] layoutIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"setLayouts", long.class, boolean.class, long.class,
					long[].class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, parentLayoutId, layoutIds);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void unschedulePublishToLive(HttpPrincipal httpPrincipal,
		long groupId, java.lang.String jobName, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"unschedulePublishToLive", long.class,
					java.lang.String.class, java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					jobName, groupName);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void unschedulePublishToRemote(HttpPrincipal httpPrincipal,
		long groupId, java.lang.String jobName, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"unschedulePublishToRemote", long.class,
					java.lang.String.class, java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					jobName, groupName);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateLayout(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long layoutId, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL, java.lang.Boolean iconImage,
		byte[] iconBytes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateLayout", long.class, boolean.class, long.class,
					long.class, java.util.Map.class, java.util.Map.class,
					java.lang.String.class, java.lang.String.class,
					boolean.class, java.lang.String.class,
					java.lang.Boolean.class, byte[].class,
					com.liferay.portal.service.ServiceContext.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, parentLayoutId, localeNamesMap,
					localeTitlesMap, description, type, hidden, friendlyURL,
					iconImage, iconBytes, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateLayout(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long layoutId, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateLayout", long.class, boolean.class, long.class,
					long.class, java.util.Map.class, java.util.Map.class,
					java.lang.String.class, java.lang.String.class,
					boolean.class, java.lang.String.class,
					com.liferay.portal.service.ServiceContext.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, parentLayoutId, localeNamesMap,
					localeTitlesMap, description, type, hidden, friendlyURL,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateLayout(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long layoutId, java.lang.String typeSettings)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateLayout", long.class, boolean.class, long.class,
					java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, typeSettings);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateLookAndFeel(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long layoutId, java.lang.String themeId,
		java.lang.String colorSchemeId, java.lang.String css, boolean wapTheme)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateLookAndFeel", long.class, boolean.class, long.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, boolean.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, themeId, colorSchemeId, css,
					wapTheme);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateName(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long layoutId, java.lang.String name, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateName", long.class, boolean.class, long.class,
					java.lang.String.class, java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, name, languageId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateName(
		HttpPrincipal httpPrincipal, long plid, java.lang.String name,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateName", long.class, java.lang.String.class,
					java.lang.String.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid,
					name, languageId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateParentLayoutId(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long layoutId, long parentLayoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateParentLayoutId", long.class, boolean.class,
					long.class, long.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, parentLayoutId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updateParentLayoutId(
		HttpPrincipal httpPrincipal, long plid, long parentPlid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updateParentLayoutId", long.class, long.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid,
					parentPlid);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updatePriority(
		HttpPrincipal httpPrincipal, long groupId, boolean privateLayout,
		long layoutId, int priority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updatePriority", long.class, boolean.class, long.class,
					int.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					privateLayout, layoutId, priority);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.Layout updatePriority(
		HttpPrincipal httpPrincipal, long plid, int priority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(LayoutServiceUtil.class.getName(),
					"updatePriority", long.class, int.class);

			MethodHandler methodHandler = new MethodHandler(methodKey, plid,
					priority);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.model.Layout)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LayoutServiceHttp.class);
}
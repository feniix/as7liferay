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

package com.liferay.portal.spring.util;

import com.liferay.portal.bean.BeanLocatorImpl;
import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.spring.context.ArrayApplicationContext;
import com.liferay.portal.util.PropsValues;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;

/**
 * <p>
 * In most cases, SpringUtil.setContext() would have been called by
 * com.liferay.portal.spring.context.PortalContextLoaderListener, configured in
 * web.xml for the web application. However, there will be times in which
 * SpringUtil will be called in a non-web application and, therefore, require
 * manual instantiation of the application context.
 * </p>
 *
 * @author Michael Young
 */
public class SpringUtil {

	public static void loadContext() {
		List<String> configLocations = ListUtil.fromArray(
			PropsValues.SPRING_CONFIGS);

		if (PropsValues.PERSISTENCE_PROVIDER.equalsIgnoreCase("jpa")) {
			configLocations.remove("META-INF/hibernate-spring.xml");
		}
		else {
			configLocations.remove("META-INF/jpa-spring.xml");
		}

		AbstractApplicationContext applicationContext =
			new ArrayApplicationContext(
				configLocations.toArray(new String[configLocations.size()]));

		applicationContext.registerShutdownHook();

		BeanLocator beanLocator = new BeanLocatorImpl(
			PortalClassLoaderUtil.getClassLoader(), applicationContext);

		PortalBeanLocatorUtil.setBeanLocator(beanLocator);
	}

}
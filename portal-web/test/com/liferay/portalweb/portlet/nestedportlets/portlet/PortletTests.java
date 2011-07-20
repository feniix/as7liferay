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

package com.liferay.portalweb.portlet.nestedportlets.portlet;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.nestedportlets.portlet.addportlet.AddPortletTests;
import com.liferay.portalweb.portlet.nestedportlets.portlet.addportletmultiple.AddPortletMultipleTests;
import com.liferay.portalweb.portlet.nestedportlets.portlet.removeportlet.RemovePortletTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletTests.suite());
		testSuite.addTest(AddPortletMultipleTests.suite());
		testSuite.addTest(RemovePortletTests.suite());

		return testSuite;
	}

}
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

package com.liferay.portalweb.portal.dbupgrade.sampledata601;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata601.address.AddressTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata601.groups.GroupsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata601.organizations.OrganizationsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata601.portletpermissions.PortletPermissionsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata601.social.SocialTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata601.tags.TagsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata601.wiki.WikiTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleData601Tests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddressTests.suite());
		testSuite.addTest(GroupsTests.suite());
		testSuite.addTest(OrganizationsTests.suite());
		testSuite.addTest(PortletPermissionsTests.suite());
		testSuite.addTest(TagsTests.suite());
		testSuite.addTest(WikiTests.suite());
		testSuite.addTest(SocialTests.suite());

		return testSuite;
	}

}
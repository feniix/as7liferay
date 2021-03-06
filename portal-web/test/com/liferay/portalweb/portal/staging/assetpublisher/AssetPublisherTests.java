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

package com.liferay.portalweb.portal.staging.assetpublisher;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetPublisherTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(LoginTest.class);
		testSuite.addTestSuite(AddAssetPublisherPageTest.class);
		testSuite.addTestSuite(AddAssetPublisherPortletTest.class);
		testSuite.addTestSuite(AddBlogsPageTest.class);
		testSuite.addTestSuite(AddBlogsPortletTest.class);
		testSuite.addTestSuite(AddBlogsEntryTest.class);
		testSuite.addTestSuite(AssertEditAssetPublisherEntryTest.class);
		testSuite.addTestSuite(ControlPanelTest.class);
		testSuite.addTestSuite(ActivateStagingTest.class);
		testSuite.addTestSuite(EndControlPanelTest.class);
		testSuite.addTestSuite(AssertCannotEditAssetPublisherEntryTest.class);
		testSuite.addTestSuite(ControlPanelTest.class);
		testSuite.addTestSuite(DeactivateStagingTest.class);
		testSuite.addTestSuite(EndControlPanelTest.class);
		testSuite.addTestSuite(AssertEditAssetPublisherEntryTest.class);
		testSuite.addTestSuite(TearDownTest.class);
		testSuite.addTestSuite(LogoutTest.class);

		return testSuite;
	}

}
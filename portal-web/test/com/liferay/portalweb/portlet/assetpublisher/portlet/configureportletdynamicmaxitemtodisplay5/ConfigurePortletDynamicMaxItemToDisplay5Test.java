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

package com.liferay.portalweb.portlet.assetpublisher.portlet.configureportletdynamicmaxitemtodisplay5;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletDynamicMaxItemToDisplay5Test extends BaseTestCase {
	public void testConfigurePortletDynamicMaxItemToDisplay5()
		throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Asset Publisher Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Configuration", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_86_delta", RuntimeVariables.replace("label=5"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[3]/div/div/div/div/div"));
		assertEquals("5", selenium.getSelectedLabel("_86_delta"));
	}
}
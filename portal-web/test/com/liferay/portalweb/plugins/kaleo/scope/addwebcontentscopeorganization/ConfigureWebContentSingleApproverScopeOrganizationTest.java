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

package com.liferay.portalweb.plugins.kaleo.scope.addwebcontentscopeorganization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigureWebContentSingleApproverScopeOrganizationTest
	extends BaseTestCase {
	public void testConfigureWebContentSingleApproverScopeOrganization()
		throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.clickAt("//div/span/a",
			RuntimeVariables.replace("Scope Selector"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//a[3]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//a[3]", RuntimeVariables.replace("3"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//ul[3]/li[3]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//ul[3]/li[3]/a",
			RuntimeVariables.replace("Organization Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Organization Name"),
			selenium.getText("//div/span/a"));
		selenium.clickAt("link=Workflow Configuration",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_152_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle",
			RuntimeVariables.replace("label=Single Approver (Version 1)"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals("Single Approver (Version 1)",
			selenium.getSelectedLabel(
				"_152_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle"));
	}
}
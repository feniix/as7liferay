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

package com.liferay.portalweb.portlet.wiki.wikipage.canceladdfrontpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CancelAddFrontPageTest extends BaseTestCase {
	public void testCancelAddFrontPage() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Wiki Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Wiki Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=This page is empty. Edit it to add some text.",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_36_content",
			RuntimeVariables.replace(
				"==Test Wiki Article==\n\n//this is italics//\n\n**bold**\n\n[[http://www.liferay.com|Link to website]]\n\n*this is a list item\n**this is a sub list item"));
		selenium.clickAt("//input[@value='Cancel']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"link=This page is empty. Edit it to add some text."));
		assertFalse(selenium.isTextPresent(
				"Your request processed successfully."));
		assertFalse(selenium.isTextPresent("Test Wiki Article"));
		assertFalse(selenium.isTextPresent("this is italics"));
		assertFalse(selenium.isTextPresent("bold"));
		assertFalse(selenium.isElementPresent("link=Link to website"));
		assertFalse(selenium.isTextPresent(
				"this is a list item this is a sub list item"));
	}
}
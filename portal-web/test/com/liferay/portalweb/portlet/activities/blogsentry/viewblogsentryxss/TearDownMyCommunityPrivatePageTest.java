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

package com.liferay.portalweb.portlet.activities.blogsentry.viewblogsentryxss;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownMyCommunityPrivatePageTest extends BaseTestCase {
	public void testTearDownMyCommunityPrivatePage() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("/group/joebloggs/home/");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"//div/div[3]/div/ul/li[1]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.clickAt("//div/div[3]/div/ul/li[1]/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("Joe Bloggs")
												.equals(selenium.getText(
										"//div/div[3]/a"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				boolean welcomePresent = selenium.isElementPresent(
						"//li/ul/li[1]/div/div[3]/a");

				if (welcomePresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//li/div/div[1]", RuntimeVariables.replace(""));

			case 2:

				boolean page1Present = selenium.isElementPresent(
						"//li[3]/div/div[3]/a");

				if (!page1Present) {
					label = 3;

					continue;
				}

				selenium.clickAt("//li[3]/div/div[3]/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//ul[2]/li[1]/span/span/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected page[\\s\\S]$"));

			case 3:

				boolean page2Present = selenium.isElementPresent(
						"//li[3]/div/div[3]/a");

				if (!page2Present) {
					label = 4;

					continue;
				}

				selenium.clickAt("//li[3]/div/div[3]/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//ul[2]/li[1]/span/span/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected page[\\s\\S]$"));

			case 4:

				boolean page3Present = selenium.isElementPresent(
						"//li[3]/div/div[3]/a");

				if (!page3Present) {
					label = 5;

					continue;
				}

				selenium.clickAt("//li[3]/div/div[3]/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//ul[2]/li[1]/span/span/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected page[\\s\\S]$"));

			case 5:

				boolean page4Present = selenium.isElementPresent(
						"//li[3]/div/div[3]/a");

				if (!page4Present) {
					label = 6;

					continue;
				}

				selenium.clickAt("//li[3]/div/div[3]/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//ul[2]/li[1]/span/span/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected page[\\s\\S]$"));

			case 6:

				boolean page5Present = selenium.isElementPresent(
						"//li[3]/div/div[3]/a");

				if (!page5Present) {
					label = 7;

					continue;
				}

				selenium.clickAt("//li[3]/div/div[3]/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//ul[2]/li[1]/span/span/a",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected page[\\s\\S]$"));

			case 7:
			case 100:
				label = -1;
			}
		}
	}
}
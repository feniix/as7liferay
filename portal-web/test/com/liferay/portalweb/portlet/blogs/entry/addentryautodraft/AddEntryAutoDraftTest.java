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

package com.liferay.portalweb.portlet.blogs.entry.addentryautodraft;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddEntryAutoDraftTest extends BaseTestCase {
	public void testAddEntryAutoDraft() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Blogs Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Blogs Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("_33_addEntryButton", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_33_title", RuntimeVariables.replace("DraftTitle"));
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_33_editor")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("cke_contents_CKEditor1")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//textarea")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.selectFrame("//iframe[@id='_33_editor']");
		selenium.selectFrame("//td[@id='cke_contents_CKEditor1']/iframe");
		selenium.type("//body", RuntimeVariables.replace("DraftContent."));
		selenium.selectFrame("relative=top");
		Thread.sleep(15000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isTextPresent("Draft saved")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isTextPresent("Draft saved"));
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Blogs Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Blogs Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("Draft")
										.equals(selenium.getText("//div[1]/h3"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("Draft"),
			selenium.getText("//div[1]/h3"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("DraftTitle")
										.equals(selenium.getText(
								"//div[2]/div[1]/div[1]/a"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("DraftTitle"),
			selenium.getText("//div[2]/div[1]/div[1]/a"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("DraftContent.")
										.equals(selenium.getText("//p"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("DraftContent."),
			selenium.getText("//p"));
	}
}
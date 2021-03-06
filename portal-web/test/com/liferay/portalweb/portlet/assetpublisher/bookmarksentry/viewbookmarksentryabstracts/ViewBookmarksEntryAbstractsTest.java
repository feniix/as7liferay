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

package com.liferay.portalweb.portlet.assetpublisher.bookmarksentry.viewbookmarksentryabstracts;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBookmarksEntryAbstractsTest extends BaseTestCase {
	public void testViewBookmarksEntryAbstracts() throws Exception {
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
		assertEquals(RuntimeVariables.replace("AP Bookmarks Entry Name"),
			selenium.getText("//div[1]/h3/a"));
		assertTrue(selenium.isPartialText("//div[2]/a", "Read More"));
		selenium.clickAt("//div[2]/a", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("AP Bookmarks Entry Name"),
			selenium.getText("//div/h3"));
		assertEquals(RuntimeVariables.replace(
				"AP Bookmarks Entry Name (http://www.liferay.com) (Opens New Window)"),
			selenium.getText("//div[2]/a"));
		assertEquals(RuntimeVariables.replace("View in Context \u00bb"),
			selenium.getText("//div[2]/div/a"));
		selenium.clickAt("//div[2]/div/a", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Liferay.com"),
			selenium.getText("logo"));
	}
}
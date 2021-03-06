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

package com.liferay.portalweb.portal.dbupgrade.sampledata527.wiki.wikipage;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiPageTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddCommunityWikiWikiPageTest.class);
		testSuite.addTestSuite(AddPageWikiWikiPageTest.class);
		testSuite.addTestSuite(AddPortletWikiWikiPageTest.class);
		testSuite.addTestSuite(AddWikiPageTest.class);
		testSuite.addTestSuite(CleanupWikiNodeTest.class);
		testSuite.addTestSuite(ViewWikiPageTest.class);

		return testSuite;
	}

}
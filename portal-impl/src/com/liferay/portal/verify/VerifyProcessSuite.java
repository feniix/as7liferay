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

package com.liferay.portal.verify;

/**
 * @author Alexander Chow
 */
public class VerifyProcessSuite extends VerifyProcess {

	protected void doVerify() throws Exception {
		verify(new VerifyProperties());

		verify(new VerifyMySQL());

		verify(new VerifyCounter());
		verify(new VerifyUUID());

		verify(new VerifyRole());

		verify(new VerifyBlogs());
		verify(new VerifyBookmarks());
		verify(new VerifyCalendar());
		verify(new VerifyDocumentLibrary());
		verify(new VerifyGroup());
		verify(new VerifyImageGallery());
		verify(new VerifyJournal());
		verify(new VerifyLayout());
		verify(new VerifyMessageBoards());
		verify(new VerifyOrganization());
		verify(new VerifySocial());
		verify(new VerifyUser());
		verify(new VerifyWiki());

		// VerifyBlogsTrackbacks looks at every blog comment to see if it is a
		// trackback and verifies that the source URL is a valid URL.

		//verify(new VerifyBlogsTrackbacks());

		// VerifyImage is very powerful because it removes all images that it
		// believes is stale. Do not run this unless you are also not managing
		// images in Liferay's Image service for your custom models.

		//verify(new VerifyImage());
	}

}
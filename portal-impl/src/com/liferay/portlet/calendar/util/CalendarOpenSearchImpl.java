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

package com.liferay.portlet.calendar.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;

/**
 * @author Brett Swaim
 */
public class CalendarOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/calendar/open_search";

	public static final String TITLE = "Liferay Calendar Search: ";

	public String getPortletId() {
		return CalIndexer.PORTLET_ID;
	}

	public String getSearchPath() {
		return SEARCH_PATH;
	}

	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

}
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

package com.liferay.portal.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.UserGroup;

/**
 * @author Brian Wing Shun Chan
 */
public class UserGroupDescriptionComparator extends OrderByComparator {

	public static String ORDER_BY_ASC =
		"UserGroup.description ASC, UserGroup.name ASC";

	public static String ORDER_BY_DESC =
		"UserGroup.description DESC, UserGroup.name DESC";

	public static String[] ORDER_BY_FIELDS = {"description", "name"};

	public UserGroupDescriptionComparator() {
		this(false);
	}

	public UserGroupDescriptionComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		UserGroup userGroup1 = (UserGroup)obj1;
		UserGroup userGroup2 = (UserGroup)obj2;

		int value = userGroup1.getDescription().compareTo(
			userGroup2.getDescription());

		if (value == 0) {
			value = userGroup1.getName().compareTo(userGroup2.getName());
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}
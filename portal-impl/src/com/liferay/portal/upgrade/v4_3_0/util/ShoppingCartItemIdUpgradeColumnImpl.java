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

package com.liferay.portal.upgrade.v4_3_0.util;

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingCartItemIdUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public ShoppingCartItemIdUpgradeColumnImpl(
		ValueMapper shoppingItemIdMapper) {

		super("itemId");

		_shoppingItemIdMapper = shoppingItemIdMapper;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String itemId = (String)oldValue;

		int pos = itemId.indexOf("|");

		if (pos == -1) {
			return String.valueOf(_shoppingItemIdMapper.getNewValue(
				new Long(GetterUtil.getLong(itemId))));
		}
		else {
			Long oldItemId = new Long(
				GetterUtil.getLong(itemId.substring(0, pos)));

			return _shoppingItemIdMapper.getNewValue(oldItemId) +
				itemId.substring(pos, itemId.length());
		}
	}

	private ValueMapper _shoppingItemIdMapper;

}
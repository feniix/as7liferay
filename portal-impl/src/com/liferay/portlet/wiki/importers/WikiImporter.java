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

package com.liferay.portlet.wiki.importers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portlet.wiki.model.WikiNode;

import java.io.File;

import java.util.Map;

/**
 * @author Jorge Ferrer
 */
public interface WikiImporter {

	public void importPages(
			long userId, WikiNode node, File[] files,
			Map<String, String[]> options)
		throws PortalException;

}
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

package com.liferay.portal.kernel.xml;

import java.io.IOException;

/**
 * @author Brian Wing Shun Chan
 */
public interface Document extends Branch {

	public Document addComment(String comment);

	public Document addDocType(String name, String publicId, String systemId);

	public String formattedString() throws IOException;

	public String formattedString(String indent) throws IOException;

	public String formattedString(String indent, boolean expandEmptyElements)
		throws IOException;

	public Element getRootElement();

	public String getXMLEncoding();

	public void setRootElement(Element rootElement);

	public void setXMLEncoding(String encoding);

}
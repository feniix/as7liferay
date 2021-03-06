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

package com.liferay.portal.tools;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.util.InitUtil;
import com.liferay.util.xml.XMLFormatter;

import java.util.Iterator;

/**
 * @author Brian Wing Shun Chan
 */
public class WebXML23Converter {

	public static void main(String[] args) {
		InitUtil.initWithSpring();

		if (args.length == 2) {
			new WebXML23Converter(args[0], args[1]);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public WebXML23Converter(String input, String output) {
		try {
			String webXML24 = FileUtil.read(input);

			Document doc = SAXReaderUtil.read(webXML24);

			Element root = doc.getRootElement();

			double version = GetterUtil.getDouble(
				root.attributeValue("version"));

			if (version == 2.4) {
				System.out.println(
					"Convert web.xml because it is Servlet 2.4");
			}
			else {
				System.out.println(
					"Do not convert web.xml because it is not Servlet 2.4");

				return;
			}

			Iterator<Element> itr1 = root.elements("filter-mapping").iterator();

			while (itr1.hasNext()) {
				Element filterMapping = itr1.next();

				Iterator<Element> itr2 = filterMapping.elements(
					"dispatcher").iterator();

				while (itr2.hasNext()) {
					Element dispatcher = itr2.next();

					dispatcher.detach();
				}
			}

			String webXML23 = doc.formattedString();

			int x = webXML23.indexOf("<web-app");
			int y = webXML23.indexOf(">", x);

			webXML23 = webXML23.substring(0, x) + "<!DOCTYPE web-app PUBLIC \"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN\" \"http://java.sun.com/dtd/web-app_2_3.dtd\"><web-app>" + webXML23.substring(y + 1, webXML23.length());

			webXML23 = StringUtil.replace(
				webXML23,
				new String[] {
					"<jsp-config>", "</jsp-config>"
				},
				new String[] {
					"", ""
				});

			webXML23 = XMLFormatter.toString(webXML23);

			FileUtil.write(output, webXML23);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
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

package com.liferay.portal.upgrade.v6_0_0;

import com.liferay.documentlibrary.service.DLServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileEntryNameUpgradeColumnImpl;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileEntryTable;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileEntryTitleUpgradeColumnImpl;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileEntryVersionUpgradeColumnImpl;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileRankTable;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileShortcutTable;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileVersionTable;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * @author Jorge Ferrer
 * @author Alexander Chow
 */
public class UpgradeDocumentLibrary extends UpgradeProcess {

	protected void addFileVersion(
			long groupId, long companyId, long userId, String userName,
			long folderId, String name, double version, int size)
		throws Exception {

		Timestamp now = new Timestamp(System.currentTimeMillis());

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataAccess.getConnection();

			StringBundler sb = new StringBundler(5);

			sb.append("insert into DLFileVersion (fileVersionId, groupId, ");
			sb.append("companyId, userId, userName, createDate, folderId, ");
			sb.append("name, version, size_, status, statusByUserId, ");
			sb.append("statusByUserName, statusDate) values (?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?)");

			String sql = sb.toString();

			ps = con.prepareStatement(sql);

			ps.setLong(1, increment());
			ps.setLong(2, groupId);
			ps.setLong(3, companyId);
			ps.setLong(4, userId);
			ps.setString(5, userName);
			ps.setTimestamp(6, now);
			ps.setLong(7, folderId);
			ps.setString(8, name);
			ps.setDouble(9, version);
			ps.setInt(10, size);
			ps.setInt(11, WorkflowConstants.STATUS_APPROVED);
			ps.setLong(12, userId);
			ps.setString(13, userName);
			ps.setTimestamp(14, now);

			ps.executeUpdate();
		}
		finally {
			DataAccess.cleanUp(con, ps);
		}
	}

	protected void doUpgrade() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement("select * from DLFileEntry");

			rs = ps.executeQuery();

			while (rs.next()) {
				long companyId = rs.getLong("companyId");
				long groupId = rs.getLong("groupId");
				long userId = rs.getLong("userId");
				String userName = rs.getString("userName");
				long folderId = rs.getLong("folderId");
				String name = rs.getString("name");
				double version = rs.getDouble("version");
				int size = rs.getInt("size_");

				String portletId = PortletKeys.DOCUMENT_LIBRARY;
				long repositoryId = folderId;

				if (repositoryId ==
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

					repositoryId = groupId;
				}

				String newName = DLFileEntryNameUpgradeColumnImpl.getNewName(
					name);

				if (!newName.equals(name)) {
					DLServiceUtil.updateFile(
						companyId, portletId, groupId, repositoryId, name,
						newName, false);
				}

				addFileVersion(
					groupId, companyId, userId, userName, folderId, name,
					version, size);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		// DLFileEntry

		UpgradeColumn nameColumn = new DLFileEntryNameUpgradeColumnImpl("name");
		UpgradeColumn titleColumn = new DLFileEntryTitleUpgradeColumnImpl(
			nameColumn, "title");
		UpgradeColumn versionColumn = new DLFileEntryVersionUpgradeColumnImpl(
			"version");

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileEntryTable.TABLE_NAME, DLFileEntryTable.TABLE_COLUMNS,
			nameColumn, titleColumn, versionColumn);

		upgradeTable.setCreateSQL(DLFileEntryTable.TABLE_SQL_CREATE);

		upgradeTable.updateTable();

		// DLFileRank

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileRankTable.TABLE_NAME, DLFileRankTable.TABLE_COLUMNS,
			nameColumn);

		upgradeTable.setCreateSQL(DLFileRankTable.TABLE_SQL_CREATE);

		upgradeTable.updateTable();

		// DLFileShortcut

		UpgradeColumn toNameColumn = new DLFileEntryNameUpgradeColumnImpl(
			"toName");

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileShortcutTable.TABLE_NAME, DLFileShortcutTable.TABLE_COLUMNS,
			toNameColumn);

		upgradeTable.setCreateSQL(DLFileShortcutTable.TABLE_SQL_CREATE);

		upgradeTable.updateTable();

		// DLFileVersion

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileVersionTable.TABLE_NAME, DLFileVersionTable.TABLE_COLUMNS,
			nameColumn, versionColumn);

		upgradeTable.setCreateSQL(DLFileVersionTable.TABLE_SQL_CREATE);

		upgradeTable.updateTable();
	}

}
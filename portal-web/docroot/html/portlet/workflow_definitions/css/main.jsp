<%
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
%>

<%@ include file="/html/portlet/css_init.jsp" %>

.lfr-asset-column-details .lfr-asset-title .lfr-asset-actions img {
	margin-left: 5px;
}

.lfr-asset-column-details .lfr-asset-actions {
	float: right;
	font-size: 11px;
	font-weight: normal;
	margin-bottom: 3px;
	margin-top: 0;
}

.lfr-asset-column-details .task-activity {
	padding: 5px 5px 5px 25px;
}

.lfr-asset-column-details .task-activity-date {
	font-weight: bold;
}

.lfr-asset-column-details .lfr-asset-assigned, .lfr-asset-column-details .lfr-asset-due-date, .lfr-asset-column-details .task-type-1, .lfr-asset-column-details .task-type-2, .lfr-asset-column-details .task-type-3, .lfr-asset-column-details .lfr-asset-date, .lfr-asset-column-details .lfr-asset-status {
	background: url() no-repeat 0 50%;
}

.lfr-asset-column-details .lfr-asset-assigned {
	background-image: url(<%= themeImagesPath %>/common/assign.png);
	margin-right: 10px;
	padding-left: 25px;
	padding-right: 10px;
}

.lfr-asset-column-details h3.task-content-title {
	margin-top: 0;
	border-bottom: 1px solid #ddd;
}

.lfr-asset-column-details .task-panel-container .lfr-panel-content {
	padding: 0.7em;
}

.lfr-asset-column-details .task-content-actions {
	float: right;
}

.lfr-asset-column-details .lfr-asset-date {
	background: url(<%= themeImagesPath %>/common/date.png) no-repeat 0 50%;
}

.lfr-asset-column-details .lfr-asset-due-date {
	background-image: url(<%= themeImagesPath %>/common/time.png);
	padding-left: 25px;
}

.lfr-asset-column-details .task-type-1 {
	background-image: url(<%= themeImagesPath %>/common/assign.png);
}

.lfr-asset-column-details .task-type-2 {
	background-image: url(<%= themeImagesPath %>/common/time.png);
}

.lfr-asset-column-details .task-type-3 {
	background-image: url(<%= themeImagesPath %>/common/recent_changes.png);
}

.lfr-asset-column-details .lfr-asset-date {
	margin-right: 10px;
	overflow: auto;
	padding-left: 25px;
	padding-right: 10px;
}

.lfr-asset-column-details .lfr-asset-status {
	background-image: url(<%= themeImagesPath %>/common/recent_changes.png);
	padding-left: 25px;
	padding-right: 10px;
}

.lfr-asset-column-details .asset-metadata {
	border-top: 1px solid #DDD;
	background-color: #EFEFEF;
	padding: 0.5em;
	margin: 2em 0 0;
}

.lfr-asset-column-details .asset-metadata span {
	display: inline;
}

.lfr-asset-column-details .metadata-author {
	background: url(<%= themeImagesPath %>/portlet/edit_guest.png) no-repeat 0 0;
	font-weight: bold;
	margin-right: 10px;
	padding-left: 25px;
	padding-bottom: 5px;
}

.lfr-asset-column-details .metadata-entry {
	clear: both;
	color: #999;
	display: block;
}

.lfr-asset-column-details .metadata-modified-date, .lfr-asset-column-details .metadata-create-date, .lfr-asset-column-details .metadata-publish-date, .lfr-asset-column-details .metadata-expiration-date {
	background: url(<%= themeImagesPath %>/common/date.png) no-repeat 0 0;
	color: #999;
	margin-bottom: 1em;
	padding-left: 25px;
}

.lfr-asset-column-details .metadata-priority {
	background: url(<%= themeImagesPath %>/common/top.png) no-repeat 0 20%;
	margin-right: 10px;
	padding-left: 25px;
}

.lfr-asset-column-details .metadata-view-count {
	margin-right: 10px;
}

.lfr-asset-column-details .vertical-separator {
	border-right: 1px solid #CCC;
	margin: 0 10px;
	padding-top: 0.1em;
}

#workflowTasksPanelContainer {
	border-width: 0;
}
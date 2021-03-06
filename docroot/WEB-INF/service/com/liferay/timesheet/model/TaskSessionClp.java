/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.timesheet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.timesheet.service.TaskSessionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Istvan Sajtos
 */
public class TaskSessionClp extends BaseModelImpl<TaskSession>
	implements TaskSession {
	public TaskSessionClp() {
	}

	public Class<?> getModelClass() {
		return TaskSession.class;
	}

	public String getModelClassName() {
		return TaskSession.class.getName();
	}

	public long getPrimaryKey() {
		return _taskSessionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTaskSessionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_taskSessionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskSessionId", getTaskSessionId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("endTime", getEndTime());
		attributes.put("startTime", getStartTime());
		attributes.put("taskId", getTaskId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskSessionId = (Long)attributes.get("taskSessionId");

		if (taskSessionId != null) {
			setTaskSessionId(taskSessionId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}
	}

	public long getTaskSessionId() {
		return _taskSessionId;
	}

	public void setTaskSessionId(long taskSessionId) {
		_taskSessionId = taskSessionId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public com.liferay.timesheet.model.Task getTask() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getTaskSessionRemoteModel() {
		return _taskSessionRemoteModel;
	}

	public void setTaskSessionRemoteModel(BaseModel<?> taskSessionRemoteModel) {
		_taskSessionRemoteModel = taskSessionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TaskSessionLocalServiceUtil.addTaskSession(this);
		}
		else {
			TaskSessionLocalServiceUtil.updateTaskSession(this);
		}
	}

	@Override
	public TaskSession toEscapedModel() {
		return (TaskSession)Proxy.newProxyInstance(TaskSession.class.getClassLoader(),
			new Class[] { TaskSession.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaskSessionClp clone = new TaskSessionClp();

		clone.setTaskSessionId(getTaskSessionId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setEndTime(getEndTime());
		clone.setStartTime(getStartTime());
		clone.setTaskId(getTaskId());

		return clone;
	}

	public int compareTo(TaskSession taskSession) {
		long primaryKey = taskSession.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TaskSessionClp taskSession = null;

		try {
			taskSession = (TaskSessionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = taskSession.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{taskSessionId=");
		sb.append(getTaskSessionId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timesheet.model.TaskSession");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taskSessionId</column-name><column-value><![CDATA[");
		sb.append(getTaskSessionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _taskSessionId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private Date _endTime;
	private Date _startTime;
	private long _taskId;
	private BaseModel<?> _taskSessionRemoteModel;
}
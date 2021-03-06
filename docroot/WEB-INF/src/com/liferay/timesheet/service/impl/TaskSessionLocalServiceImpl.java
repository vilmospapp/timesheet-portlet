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

package com.liferay.timesheet.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.timesheet.model.TaskSession;
import com.liferay.timesheet.service.base.TaskSessionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the task session local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timesheet.service.TaskSessionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Istvan Sajtos
 * @see com.liferay.timesheet.service.base.TaskSessionLocalServiceBaseImpl
 * @see com.liferay.timesheet.service.TaskSessionLocalServiceUtil
 */
public class TaskSessionLocalServiceImpl
	extends TaskSessionLocalServiceBaseImpl {

	public TaskSession addTaskSession(
			Date startTime, Date endTime, long taskId, long userId)
		throws SystemException {

		long taskSessionId = counterLocalService.increment();

		TaskSession taskSession = taskSessionPersistence.create(taskSessionId);

		Date now = new Date();

		taskSession.setCreateDate(now);
		taskSession.setEndTime(endTime);
		taskSession.setModifiedDate(now);
		taskSession.setStartTime(startTime);
		taskSession.setTaskId(taskId);
		taskSession.setUserId(userId);

		taskSessionPersistence.update(taskSession, false);

		return taskSession;
	}

	public TaskSession addTaskSession(Date startTime, long taskId, long userId)
		throws SystemException {

		return addTaskSession(startTime, null, taskId, userId);
	}

	public TaskSession getCurrentTaskSession(long userId)
		throws SystemException {

		return taskSessionPersistence.fetchByU_E(userId, null);
	}

	public List<TaskSession> getTaskSessionsByD_U(Date date, long userId)
		throws SystemException {

		List<TaskSession> taskSessions =
			taskSessionPersistence.findByU_GtS(userId, date);

		return taskSessions;
	}

	public TaskSession updateTaskSession(TaskSession taskSession)
		throws SystemException {

		Date now = new Date();

		taskSession.setModifiedDate(now);

		taskSessionPersistence.update(taskSession, false);

		return taskSession;
	}

}
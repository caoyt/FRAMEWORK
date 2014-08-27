package com.caoyt.framework.pojo;

import org.jbpm.api.task.Task;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc 2014-8-26 上午10:20:24
 * 
 * 每个任务对应的申请信息
 * 
 */
public class TaskView {
	private Task task;
	private TApplication application;

	public TaskView() {
	}

	public TaskView(Task task, TApplication application) {
		this.task = task;
		this.application = application;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TApplication getApplication() {
		return application;
	}

	public void setApplication(TApplication application) {
		this.application = application;
	}

}

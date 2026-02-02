package com.garden.bean;

import java.sql.Date;

public class PlotTaskRow {
    private int rowID;
    private String gardenerID;
    private String serviceType;
    private String plotNo;
    private String seasonName;
    private Date allocationStartDate;
    private Date allocationEndDate;
    private Date taskDate;
    private String taskType;
    private String taskNotes;
    private String taskStatus;
	public int getRowID() {
		return rowID;
	}
	public void setRowID(int rowID) {
		this.rowID = rowID;
	}
	public String getGardenerID() {
		return gardenerID;
	}
	public void setGardenerID(String gardenerID) {
		this.gardenerID = gardenerID;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	public Date getAllocationStartDate() {
		return allocationStartDate;
	}
	public void setAllocationStartDate(Date allocationStartDate) {
		this.allocationStartDate = allocationStartDate;
	}
	public Date getAllocationEndDate() {
		return allocationEndDate;
	}
	public void setAllocationEndDate(Date allocationEndDate) {
		this.allocationEndDate = allocationEndDate;
	}
	public Date getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskNotes() {
		return taskNotes;
	}
	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}

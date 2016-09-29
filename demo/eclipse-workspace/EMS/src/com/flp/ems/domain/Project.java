package com.flp.ems.domain;

public class Project {
String projId,name,description;
Department depId;

public Project(String projId, String name, String description, Department depId) {
	super();
	this.projId = projId;
	this.name = name;
	this.description = description;
	this.depId = depId;
}
public String getProjId() {
	return projId;
}
public void setProjId(String projId) {
	this.projId = projId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Department getDepId() {
	return depId;
}
public void setDepId(Department depId) {
	this.depId = depId;
}
}

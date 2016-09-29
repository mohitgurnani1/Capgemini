package com.flp.ems.domain;

import java.util.Date;

public class Employee {

	private String empId,name,kinId,emailId,phoneNo,address;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((kinId == null) ? 0 : kinId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (kinId == null) {
			if (other.kinId != null)
				return false;
		} else if (!kinId.equals(other.kinId))
			return false;
		return true;
	}
	public Employee(String empId, String name, String kinId, String emailId, String phoneNo, String address, Date dob,
			Date doj, Department depid, Project projid, Role roleid) {
		super();
		this.empId = empId;
		this.name = name;
		this.kinId = kinId;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.address = address;
		this.dob = dob;
		this.doj = doj;
		this.depid = depid;
		this.projid = projid;
		this.roleid = roleid;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKinId() {
		return kinId;
	}
	public void setKinId(String kinId) {
		this.kinId = kinId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Department getDepid() {
		return depid;
	}
	public void setDepid(Department depid) {
		this.depid = depid;
	}
	public Project getProjid() {
		return projid;
	}
	public void setProjid(Project projid) {
		this.projid = projid;
	}
	public Role getRoleid() {
		return roleid;
	}
	public void setRoleid(Role roleid) {
		this.roleid = roleid;
	}
	private Date dob,doj;
	private Department depid;
	private Project projid;
	private Role roleid;
	
	
	
}
package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public class EmployeeDaoImplForList implements IEmployeeDao {
private ArrayList<Employee> empList;
private ArrayList<Department> deptList;
private ArrayList<Project> projectList;
private ArrayList<Role> roleList;
private static EmployeeDaoImplForList dao=null;

 private EmployeeDaoImplForList() {
empList=new ArrayList<Employee>();
deptList=new ArrayList<Department>();
projectList=new ArrayList<Project>();
roleList=new ArrayList<Role>();
dao=this;
 }

public static  EmployeeDaoImplForList getDaoReference(){
	 if(dao==null)
		 return new EmployeeDaoImplForList();
	 else
		 return dao;
 }
 
 
 
	@Override
	public boolean AddEmployee(Employee emp) {
		empList.add(emp);
		return true;
	}

	@Override
	public boolean ModifyEmployee(Employee emp) {
		String empId=emp.getEmpId();
		Employee temp=null;
		for(Employee e: empList){
			if(e.getEmailId().equals(empId))
			{
			temp=e;
			break;
			}
		}
		if(temp!=null){
		empList.remove(temp);
		empList.add(emp);
		return true;
		}
		else
		return false;
	}

	@Override
	public boolean RemoveEmployee(String empId) {
		Employee temp=null;
		for(Employee e: empList){
			if(e.getEmailId().equals(empId))
			{
			temp=e;
			break;
			}
		}
		if(temp!=null){
		empList.remove(temp);
		return true;
		}
		else
		return false;
	}

	@Override
	public Employee SearchEmployee(HashMap<String, String> emp) {
		Employee temp=null;
		if(emp.containsKey("kinId"))
		for(Employee e: empList){
			if(e.getKinId().equals(emp.get("kinId")))
			{
			temp=e;
			break;
			}
		}
		else if(emp.containsKey("name"))
		{
			
			for(Employee e: empList){
				if(e.getName().equals(emp.get("name")))
				{
				temp=e;
				break;
				}

			}
		}
		else{
			
			for(Employee e: empList){
				if(e.getEmailId().equals(emp.get("emailId")))
				{
				temp=e;
				break;
				}
			
		}
		
		}	
		
		if(temp!=null){
		return temp;
		}
		else
		return null;
	}

	@Override
	public Employee[] getAllEmployee() {
	Employee[] e=new Employee[empList.size()];
	empList.toArray(e);
		return e;
	}

}

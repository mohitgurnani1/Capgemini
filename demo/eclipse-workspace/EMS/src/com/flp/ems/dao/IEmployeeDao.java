package com.flp.ems.dao;
import com.flp.ems.domain.Employee;
import java.util.HashMap;

public interface IEmployeeDao {

	public boolean AddEmployee(Employee emp);
	public boolean ModifyEmployee(Employee emp);
	public boolean RemoveEmployee(String empId);
	public Employee SearchEmployee(HashMap<String, String> emp);
	public Employee[] getAllEmployee();
	
}

package com.flp.ems.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public class EmployeeServiceImpl implements IEmployeeService {

	
	
	
	
	@Override
	public boolean AddEmployee(HashMap<String,String> emp)  {
		// TODO Auto-generated method stub
		Date dob=null,doj=null;
		SimpleDateFormat d=new SimpleDateFormat("dd-mm-yyyy");
		
		String name=(String) emp.get("name");
		String phone=(String) emp.get("phoneNo");
		String address=(String) emp.get("address");
			try{	
		 dob=d.parse((String) emp.get("dob"));
		 doj=d.parse((String) emp.get("doj"));
			}
		catch(Exception e){}
		
		String dept=(String) emp.get("dept");
		String proj=(String) emp.get("project");
		String role=(String) emp.get("role");
		String empId=generateEmployeeId();
		String emailId=generateEmailId();
		String kinId=generateKinId();
		
		Department depNew=new Department(dept, getDepartmentList().get(dept), "good");
		Project projNew=new Project(proj, getProjectList(dept).get(proj), "good",depNew);
		Role roleNew=new Role(role, getRolesList().get(role), "good");
		Employee employee=new Employee(empId, name, kinId, emailId, phone, address, dob, doj, depNew, projNew, roleNew);
		EmployeeDaoImplForList dao= EmployeeDaoImplForList.getDaoReference();
		dao.AddEmployee(employee);
		return true;
	}

	private String generateEmailId() {
	Random r=new Random();
		return "mohit"+r.nextInt(1000);
	}

	private String generateKinId() {
		Random r=new Random();
		return "abc"+r.nextInt(100);
	}

	private String generateEmployeeId() {
		Random r=new Random();
		return "cdf"+r.nextInt(100);
	}

	@Override
	public boolean ModifyEmployee(HashMap emp) {
		// TODO Auto-generated method stub

		
		return false;
	}

	@Override
	public boolean RemoveEmployee(String empId, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap SearchEmployee(HashMap<String, String> emp) {
		EmployeeDaoImplForList dao= EmployeeDaoImplForList.getDaoReference();
		Employee e=dao.SearchEmployee(emp);
		 HashMap<String,String>hm=new HashMap();
		
					hm.put("name",e.getName());
					hm.put("kinId",e.getKinId());
					hm.put("emailId",e.getEmailId());
					hm.put("role",e.getRoleid().getName());
					hm.put("project",e.getProjid().getName());
					hm.put("dept",e.getDepid().getName());
		
			return hm;

	}

	@Override
	public HashMap[] getAllEmployee() {
		EmployeeDaoImplForList dao= EmployeeDaoImplForList.getDaoReference();
		Employee[] e= dao.getAllEmployee();
	 HashMap<String,String>hm[]=new HashMap[e.length];
	for(int i=0;i< e.length;i++){
			hm[i].put("name",e[i].getName());
			hm[i].put("kinId",e[i].getKinId());
			hm[i].put("emailId",e[i].getEmailId());
			hm[i].put("role",e[i].getRoleid().getName());
			hm[i].put("project",e[i].getProjid().getName());
			hm[i].put("dept",e[i].getDepid().getName());
	}
	return hm;
	}

	public  HashMap<String, String> getRolesList() {
		HashMap<String,String> roles=new HashMap();
		roles.put("r1", "Developer");
		roles.put("r2", "Tech Lead");
		roles.put("r3", "Manager");
		
		
		return roles;
	}

	public  HashMap<String, String> getDepartmentList() {
		HashMap<String,String> dept=new HashMap();
		
		dept.put("d1", "Dept1");
		dept.put("d2", "Dept2");
		dept.put("d3", "Dept3");
		
		
		return dept;
	}
	
	public  HashMap<String, String> getProjectList(String dept) {
		
		HashMap<String,String> project=new HashMap();
		project.put("p1", "Proj 1");
		project.put("p2", "Proj 2");
		project.put("p3", "Proj 3");
		project.put("p4", "Proj 4");
		project.put("p5", "Proj 5");
		project.put("p6", "Proj 6");
		
		
		return project;
	}
	

}
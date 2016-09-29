package com.flp.ems.view;

import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;

public class UserInteraction {
private static Scanner scan;

static{
	scan=new Scanner(System.in);
}
	public static void addEmployee() {
		HashMap<String, String> emp=new HashMap<String,String>();
		EmployeeServiceImpl e=new EmployeeServiceImpl();
		
		System.out.println("ADD EMPLOYEE\n Enter your  Information");
		
		System.out.println("Enter Name:");
		emp.put("name", scan.nextLine());
		
		System.out.println("Enter Phone no:");
		emp.put("phoneNo", scan.nextLine());
		
		System.out.println("Enter Address:");
		emp.put("address", scan.nextLine());
		
		System.out.println("Enter Date of birth:");
		emp.put("dob", scan.nextLine());
		
		System.out.println("Enter Date of Joining:");
		emp.put("doj", scan.nextLine());
		
		System.out.println("Enter Department:");
		
		HashMap deptlist=e.getDepartmentList();
		for(Object dept:deptlist.keySet())
		{
			System.out.println((String)dept); 
		}
		String deptId=scan.nextLine();
		emp.put("dept",deptId );
		
		System.out.println("Enter Project:");
		
		HashMap projlist=e.getProjectList(deptId);
		for(Object proj:projlist.keySet())
		{
			System.out.println((String)proj); 
		}
		emp.put("project", scan.nextLine());
		
		System.out.println("Enter Roles:");

		HashMap roleslist=e.getRolesList();
		for(Object role:roleslist.keySet())
		{
			System.out.println((String)role); 
		}
		emp.put("role", scan.nextLine());
		if(e.AddEmployee(emp))
			System.out.println("Employee added successfully");
		else
			System.out.println("Employee couldnt be added");
		
	}
	

	public static void modifyEmployee() {
		
		HashMap<String, String> emp=new HashMap<String,String>();
		EmployeeServiceImpl e=new EmployeeServiceImpl();
	
		
		System.out.println("MODIFY EMPLOYEE: ");
		
		int option=0;
		do{
			System.out.println("Select option you want to modify\n1. Name\n2. Phone no\n3. Address\n4. Exit");
			option=scan.nextInt();
			switch(option){
			case 1: 
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
				break;
			case 2:
				System.out.println("Enter Phone no");
				emp.put("phoneNo", scan.nextLine());
				break;
			case 3:
				System.out.println("Enter Address");
				emp.put("address", scan.nextLine());
				break;
			case 4:
				break;
				default:
					break;
			}
		}while(option!=4);
		
		e.ModifyEmployee(emp);
	}
	

	public static void removeEmployee() {
		EmployeeServiceImpl e=new EmployeeServiceImpl();
		
		
	System.out.println("REMOVE  EMPLOYEE: ");
		
		int option=0;
			String key=null,value=null;
			System.out.println("Search Employee by one of the given option \n1. Kin Id\n2. Email Id\n3. Name\n4. Select from Summary");
			option=scan.nextInt();
			switch(option){
			case 1: 
				System.out.println("Enter Kin Id");
				key="kinId";
				value=scan.nextLine();
				break;
			case 2:
				key="emailId";
				value=scan.nextLine();
				break;
			case 3:
				key="name";
				value=scan.nextLine();		
				break;
			case 4:
				System.out.println("Enter email Id of employee from summary you want to delete");
				getAllEmployee();
				key="emailId";
				value=scan.nextLine();	
				break;
		default:
			break;
			}
		
	System.out.println("Enter Yes/No to confirm whether you want to delete employee id "+value);
	String condition=scan.nextLine();
	if(condition.equals("Yes"))
		{if(e.RemoveEmployee(key,value))
			System.out.println("Employee deleted successfully");
		else
			System.out.println("Employee couldnt be deleted");
		}
		
		
	}
	

	public static void searchEmployee() {
	
		HashMap<String, String> emp=new HashMap<String,String>();
		EmployeeServiceImpl e=new EmployeeServiceImpl();

		
		System.out.println("SEARCH  EMPLOYEE: ");
		
		int option=0;
		
			System.out.println("Search Employee by one of the given option \n1. Kin Id\n2. Email Id\n3. Name\n4. Kin Id and Email Id\n5. EmailId and Name\n6. KinId and Name\n7. All 3");
			option=scan.nextInt();
			switch(option){
			case 1: 
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				break;
			case 2:
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				break;
			case 3:
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
				break;
		
			case 4:
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				break;
			case 5:
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
		
				break;
			case 6:
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
		
				break;
			case 7:
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
			break;
			default:
					break;
			
			}
			
		HashMap<String,String> hm=e.SearchEmployee(emp);
		System.out.println(""+hm.get("kinId")+"		"+hm.get("emailId")+"		"+hm.get("name")+"		"+hm.get("role")+"		"+hm.get("dept")+"			"+hm.get("project"));
			
		
		
	}
	

	public static void getAllEmployee() {
		HashMap<String, String> emp[];
		EmployeeServiceImpl e=new EmployeeServiceImpl();
		emp=e.getAllEmployee();
		for(HashMap<String,String> hm:emp)
			System.out.println(""+hm.get("kinId")+"		"+hm.get("emailId")+"		"+hm.get("name")+"		"+hm.get("role")+"		"+hm.get("dept")+"			"+hm.get("project"));
	}

}
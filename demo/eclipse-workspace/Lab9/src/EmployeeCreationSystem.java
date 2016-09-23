import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class EmployeeCreationSystem{

static Employee emp[];
static Contractor contractor;
static int contractno,permanentno;
static Scanner scan;
public static void main(String[] args){

	
scan=new Scanner(System.in);
contractor=new Contractor("Mohit");


System.out.println("How many employees you want to create of Contract Based Category? under Mohit");
contractno=scan.nextInt();
scan.nextLine();

System.out.println("How many employees you want to create of Permanent Category?");
permanentno=scan.nextInt();
scan.nextLine();


emp=new Employee[contractno+permanentno];


createPermanentEmp();
createContractEmp();


System.out.println("Total No of Permanent employees hired so far are "+getPermanentTotalEmpCount());
System.out.println("total no of Contract employees hired so far are "+getContractTotalEmpCount());

System.out.println("No of employees in company are "+countExistingEmp());
System.out.println("total no of employees hired so far are "+countTotalEmp());

try {
	System.out.println(getEmpById(3).printInformation());
} catch (EmployeeNotFoundException e) {
	System.out.println(e.getMessage());
	
	// TODO Auto-generated catch block
	//e.printStackTrace();
//	System.out.println("No Such Employee");
}



}






private static void createContractEmp() {
	// TODO Auto-generated method stub

for(int i=0;i<contractno;i++)
{

System.out.println("Enter your Firstname");
String fname=scan.nextLine();
System.out.println("Enter your Lastname");
String lname=scan.nextLine();
System.out.println("Enter your grade");
String grade=scan.nextLine();
System.out.println("Enter your joining month");
String joiningmonth=scan.nextLine();
MyDate md=new MyDate(joiningmonth);

//Contractor.ContractEmployee emp;  Correct approach
Employee employee;
employee=contractor.new ContractEmployee(fname, lname, 10, 10, grade, md, "Mohit");
employee.setEmpId("EMP"+Employee.countEmployee());

emp[i]=employee;

}
	
}


private static void createPermanentEmp() {
	// TODO Auto-generated method stub


for(int i=contractno;i<contractno+permanentno;i++)
{

System.out.println("Enter your Firstname");
String fname=scan.nextLine();
System.out.println("Enter your Lastname");
String lname=scan.nextLine();
System.out.println("Enter your salary");
double salary=Double.parseDouble(scan.nextLine());
System.out.println("Enter your grade");
String grade=scan.nextLine();
System.out.println("Enter your joining month");
String joiningmonth=scan.nextLine();
MyDate md=new MyDate(joiningmonth);
Employee e=new PermanentEmployee(fname,lname,salary,grade,md);
e.setEmpId("EMP"+Employee.countEmployee());
emp[i]=e;
}

}


public static int countExistingEmp(){
return emp.length;
}

public static int countTotalEmp(){
return Employee.countEmployee();
}

public static int getPermanentTotalEmpCount(){
	return PermanentEmployee.countPEEmployee();
}


public static int getContractTotalEmpCount(){
return contractor.countCEmployee();
}

public static Employee getEmpById(int id) throws EmployeeNotFoundException{
Employee e=null;	
		if(id<emp.length && id>=0)
			e=emp[id];
		else
			throw new EmployeeNotFoundException("Cannot find employee from its id bro");
return e;
}


}
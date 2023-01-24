package dao;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface EmployeeDao {
//add methods to save emp details
	
	String addEmpDetails(Employee newEmp);
	List<Employee> DisplayAllEmployeeeGtSal(Department dept,double salary);
	List<Employee> DisplayPermentEmployee();
	String PromotionOfEmployee(String fn,String Ln,Department dept, double incrementSal);
	//3.4 Delete all temporary employees
	String deleteEmp(Long empid);
}

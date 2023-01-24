package tester;
import static utils.HibernetUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;


public class AddEmpDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try(SessionFactory sf =getFactory();
				Scanner sc=new Scanner(System.in)) {
			System.out.println("Hibernate booting");
			EmployeeDaoImpl empdao=new EmployeeDaoImpl();
			System.out.println("Enter emp details : firstName,  lastName,  " 
					+ "dept,  salary,  dob, isPermanent");
			Employee empobj=new Employee(sc.next(), sc.next(), Department.valueOf(sc.next()),
					                     sc.nextDouble(), LocalDate.parse(sc.next()), 
					                     sc.nextBoolean());
		System.out.println(empdao.addEmpDetails(empobj));
		}
		catch (Exception e) {
		e.printStackTrace();
			// TODO: handle exception
		}
	}

}

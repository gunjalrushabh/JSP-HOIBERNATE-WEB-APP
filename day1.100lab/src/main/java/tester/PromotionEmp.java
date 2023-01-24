package tester;

import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

public class PromotionEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
		Employee emp=new Employee();
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		System.out.println("fn,ln,select dept :RND,FINANCE,MARKETING,HR,BILLING, %incre sal");
		
	System.out.println(dao.PromotionOfEmployee(sc.next(), sc.next(), Department.valueOf(sc.next().toUpperCase()),sc.nextDouble()));
	}

}

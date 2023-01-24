package tester;

import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class DeletEmploy {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		Employee emp=new Employee();
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		System.out.println("enter id");
		System.out.println(dao.deleteEmp(sc.nextLong()));

	}

}

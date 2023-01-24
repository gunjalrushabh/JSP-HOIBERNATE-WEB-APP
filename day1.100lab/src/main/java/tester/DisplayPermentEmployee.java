package tester;

import dao.EmployeeDaoImpl;

public class DisplayPermentEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EmployeeDaoImpl emp= new EmployeeDaoImpl();
emp.DisplayPermentEmployee().forEach(System.out::println);
 
	}

}

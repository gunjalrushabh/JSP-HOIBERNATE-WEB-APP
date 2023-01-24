package tester;
import static utils.HibernetUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

public class DisplayEmpOnDeptOnSal {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc= new Scanner(System.in)) {
			
			System.out.println("enter dept and Sal");
			System.out.println("RND,FINANCE,MARKETING,HR,BILLING");
			EmployeeDaoImpl emp =new EmployeeDaoImpl();
			Employee emp1 =new Employee();
			//List<Employee> list=(List<Employee>)emp.DisplayAllEmployeeeGtSal(Department.valueOf(sc.next().toUpperCase()), sc.nextDouble());
//			for (Employee employee : list) {
//				System.out.println(employee);
//			}
			//list.stream().forEach(p->System.out.println(p.));
			//list.forEach(System.out::println);
		System.out.println("R");
			emp.DisplayAllEmployeeeGtSal(Department.valueOf(sc.next().toUpperCase()), sc.nextDouble()).forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

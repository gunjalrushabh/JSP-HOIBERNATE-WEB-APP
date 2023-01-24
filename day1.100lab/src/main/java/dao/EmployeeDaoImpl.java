package dao;

import pojos.Department;
import pojos.Employee;
import org.hibernate.*;
import static utils.HibernetUtils.getFactory;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmpDetails(Employee newEmp) {
		// TODO Auto-generated method stub
		String message = "Adding emp fail";
		// 1 getsession from SF(session factory)
		Session session = getFactory().getCurrentSession();
		// 2 Begiin a tx
		Transaction tx = session.beginTransaction();
		try {
			// sesssio api : public serializable save(Object transientObjectRef) throws
			// Hibernate exception
			Long empId = (Long) session.save(newEmp);
			/*
			 * The "save" method returns the primary key of the saved object. This primary
			 * key can be used later to retrieve the object from the database.
			 */
			// newEmp: persistant=>entry added into l1 catche

			tx.commit();// Hibernate perform dirty checking-> session.flush()

			// DML-- insert-- sessio.close()-> l1 cache destroyed and returns DB Connection
			// pool(DBCP)
			// newEmp : detached (from l1 Cache)
			message = "Succefully added ID: " + empId;
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// rethrow same exception to caller
			// so that callwer will be know abt exception
			throw e;

		}
		return message;
	}

	@Override
	public List<Employee> DisplayAllEmployeeeGtSal(Department dept, double salary) {

		List<Employee> emplist = null;
		String jpql = "select e from Employee e where e.department=:department and e.salary>:sal";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			emplist = session.createQuery(jpql, Employee.class).setParameter("department", dept)
					.setParameter("sal", salary).getResultList();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return emplist;
	}

	@Override
	public List<Employee> DisplayPermentEmployee() {
// emp id , first name , last name , salary for a
		List<Employee> emplist = null;
		EmployeeDaoImpl empdao = new EmployeeDaoImpl();
		String jpql = "select new pojos.Employee(empid,firstName,lastName) from Employee e where e.isPermanent=false";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			emplist = session.createQuery(jpql, Employee.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}

		return emplist;
	}

	@Override
	public String PromotionOfEmployee(String fn, String Ln,Department dept, double incrementSal) {
		String message="Employ Promotion failed";
		String jpql="select e from Employee e where e.firstName=:fn and e.lastName=:Ln";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try
		{
			Employee emp=session.createQuery(jpql, Employee.class).setParameter("fn", fn).setParameter("Ln", Ln).getSingleResult();
			emp.setDepartment(dept);
			emp.setSalary(emp.getSalary()+emp.getSalary()*incrementSal/100);
		tx.commit();
		message="Promoted";
		}
		catch(Exception e)
		{
		if(tx!=null) 
			tx.rollback();	
		}	
				return message;
	}

	@Override
	public String deleteEmp(Long i) {
		
		
		String meassge="failed to delete";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try
		{
		Employee emp=session.get(Employee.class, i);
		if(emp !=null) {
		session.delete(emp);
		meassge="employ deleted";
		}
		else System.out.println("deleted failed");
		
		tx.commit();	
		}
		catch(Exception e)
		{
		if(tx!=null) 
			tx.rollback();	
		}
		
		return meassge;
	}

}

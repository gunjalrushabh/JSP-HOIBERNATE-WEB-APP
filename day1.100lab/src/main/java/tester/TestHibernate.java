package tester;
import static utils.HibernetUtils.getFactory;

import org.hibernate.SessionFactory;
public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(SessionFactory sf =getFactory()) {
			System.out.println("Hibernate booting");
		}
		catch (Exception e) {
		e.printStackTrace();
			// TODO: handle exception
		}
	}

}

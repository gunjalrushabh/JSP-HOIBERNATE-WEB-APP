package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HibernetUtils {
private static SessionFactory factory;
static {
	System.out.println("in ststic init block");
	//build singleton immutBLE THREADSAFE SEESION FACCTORY
	factory=new Configuration().configure().buildSessionFactory();
}
public static SessionFactory getFactory() {
	return factory;
}

}

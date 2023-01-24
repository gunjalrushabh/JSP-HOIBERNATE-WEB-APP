package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="emps", uniqueConstraints = @UniqueConstraint(columnNames={"first_name","last_name"}))

public class Employee {
	
	
/*
 * 
 * Employee : id (auto_increment : PK) , first name ,last name , 
 * department (enum : RND,FINANCE,MARKETING,HR,BILLING), salary, dob(LocalDate) ,isPermanent(boolean)
Annotations
@Entity , @Table, @Id, @GeneratedValue(strategy=GenerationType.IDENTITY)
, @Column , @Enumerated, ....
table : employees*/
	
	@Id//pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)//=>Auto increment
	@Column(name="emp_id")
	private Long empid;
	@Column(name="first_name",length = 30)
	private String firstName;
	@Column(name = "last_name",length = 30)
	private String lastName;
	@Enumerated(EnumType.STRING)//col type :varchar,enum
	@Column(length = 25)
	private Department department;
	private double salary;
	private LocalDate dob;
	@Column(name="is_permanent")
	private boolean isPermanent;
	
	public Employee()
	{
		
	}
	
	

	
	
	
	// emp id , first name , last name , salary for a
	
	public Employee(Long empid, String firstName, String lastName)
	{
		this.empid=empid;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public Employee( String firstName, String lastName, Department department, double salary, 
			LocalDate dob,
			 
			boolean isPermanent) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.salary = salary;
		this.dob = dob;
		this.isPermanent = isPermanent;
	}
	
	
	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", salary=" + salary + ", dob=" + dob + ", isPermanent=" + isPermanent + "]";
	}
	
	
}

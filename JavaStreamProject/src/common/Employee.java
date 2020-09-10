package common;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Employee {
	int employeeId;
	String firstName;
	String lastName;
	String email;
	LocalDate hireDate;
	String jobId;
	int salary;
	public Employee(int employeeId, String firstName, String lastName, String email, LocalDate hireDate, String jobId,
			int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public static List<Employee> getEmpList(){
		Employee e1 = new Employee(1, "Heo","sj","sj@na.com",LocalDate.of(2000, Month.MARCH,3),"사장", 15000);
		Employee e2 = new Employee(2, "Kim","ms","ms@ng.com",LocalDate.of(2000, Month.SEPTEMBER,3),"부사장", 10000);
		Employee e3 = new Employee(3, "Choi","jh","jh@nf.com",LocalDate.of(2010, Month.AUGUST,5),"과장", 7000);
		Employee e4 = new Employee(4, "Dong","gh","gh@nd.com",LocalDate.of(2016, Month.AUGUST,8),"차장", 6000);
		Employee e5 = new Employee(5, "Gang","jn","sjn@ns.com",LocalDate.of(2018, Month.JULY,6),"팀장", 5000);
		Employee e6 = new Employee(6, "Park","ch","ch@nh.com",LocalDate.of(2020, Month.MAY,3),"직원",3500);
		Employee e7 = new Employee(7, "Yang","ya","ya@nh.com",LocalDate.of(2020, Month.NOVEMBER,3),"직원",3500);
		List<Employee> employees=Arrays.asList(e1,e2,e3,e4,e5,e6,e7);
		return employees;
		
	}
	
}

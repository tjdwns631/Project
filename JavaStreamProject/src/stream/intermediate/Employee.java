package stream.intermediate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

enum Gender {
	MALE, FEMALE;
}

public class Employee {
	String name;
	Gender gender;
	LocalDate dateOfBirth;
	double income;
	public Employee(String name, Gender gender, LocalDate dateOfBirth, double income) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.income = income;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public boolean isMale() {
		return this.gender == Gender.MALE; 
	}
	
	public boolean isFemale() {
		return this.gender == Gender.FEMALE;
	}
	@Override
	public String toString() {
		String str = String.format("(%s,%s,%s,%.2f)",name,gender,dateOfBirth,income);
		return str;
	}
	public static List<Employee> employees(){
		Employee e1 = new Employee("Jun", Gender.MALE,LocalDate.of(1993,Month.JULY,5),6789.0);
		Employee e2 = new Employee("Hwang", Gender.FEMALE,LocalDate.of(1990,Month.MARCH,10),2345.0);
		Employee e3 = new Employee("Chol", Gender.MALE,LocalDate.of(1994,Month.AUGUST,15),4567.0);
		Employee e4 = new Employee("Kim", Gender.FEMALE,LocalDate.of(1995,Month.SEPTEMBER,1),5678.0);
		Employee e5 = new Employee("Park", Gender.MALE,LocalDate.of(1991,Month.MAY,7),1234.0);
		Employee e6 = new Employee("Ryu", Gender.FEMALE,LocalDate.of(1992,Month.OCTOBER,19),3456.0);
		List<Employee> employees=Arrays.asList(e1,e2,e3,e4,e5,e6);
		return employees;
		
	}
	
}

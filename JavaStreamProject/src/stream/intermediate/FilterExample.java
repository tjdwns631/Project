package stream.intermediate;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample {
public static void main(String[] args) {
	List<Employee> list = Employee.employees();
//	list.stream().filter(new Predicate<Employee>() {
//		@Override
//		public boolean test(Employee t) {
//			return t.isMale();//return 타입 이 true 인것만 보여줌
//		}
//	}).peek(s->{s.setIncome(s.getIncome()*0.9);
//	}).forEach(System.out::println);
//  연봉 감소
	
	list.stream().filter(new Predicate<Employee>() {
		@Override
		public boolean test(Employee t) {
			return t.getIncome() > 5000.0;
		}
	}).forEach(System.out::println);
	System.out.println("----------------------------");
	
	list.stream().filter(new Predicate<Employee>() {
		@Override
		public boolean test(Employee t) {
			return t.getDateOfBirth().isAfter(LocalDate.of(1994,1,1));
		}
	}).forEach(System.out::println);
		
	
}
}

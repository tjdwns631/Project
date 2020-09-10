package common;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamMapExample {
	public static void main(String[] args) {
// List<Employee>employees=EmpDAO.getEmpList();
// salary가 10000이상인 사람 출력
//		LocalDate date = LocalDate.of(2010, 5, 3);
//		LocalDate.parse("2010-05-05", DateTimeFormatter.ISO_DATE);
//		date.format(DateTimeFormatter.ISO_DATE);
		List<Employee> list = new ArrayList<>();
		try {
			list = EmpDAO.getEmpList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		list.stream().filter(d -> d.getEmployeeId() > 150)
//				.forEach(s -> System.out.println(s.getEmployeeId()));
		Optional<LocalDate> result =list.stream().flatMap(new Function<Employee, Stream<LocalDate>>() {
				@Override
				public Stream<LocalDate> apply(Employee t) {
					return Stream.of(t.getHireDate());
				}
			}).reduce(new BinaryOperator<LocalDate>() {
				@Override
				public LocalDate apply(LocalDate t, LocalDate u) {
					System.out.println(t + "," + u);
					return t.isBefore(u)? t:u;
				}
			});
			System.out.println(result.get());
			list.stream();
	}
}

package stream.collect;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseExample {
	public static void main(String[] args) {
//employee 테이블
//1990suseo 입사한사람
//list컬렉션에 저장
		List<Employee> list =new ArrayList<>();
		try {
			list =EmpDAO.getEmpList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Collector<Employee,?,List<Employee>> collector = Collectors.toList();
		List<Employee> newList = list.stream().filter(s-> s.getHireDate()
		.isAfter(LocalDate.of(1990, 01,01)))
		.filter(s->s.getHireDate().isBefore(LocalDate.of(2000,01,01)))
		.collect(collector);
		
//		newList.stream().forEach(s->System.out.println(s.getHireDate()));
	Map<String,Integer> map = newList.stream().filter(s-> s.getJobId().equals("ST_CLERK"))
		.collect(Collectors.toMap(new Function<Employee,String>() {
			@Override
			public String apply(Employee t) {
				return t.getFirstName();
			}
		}, new Function<Employee, Integer>() {

			@Override
			public Integer apply(Employee t) {
				return t.getSalary();
			}
		}));
		Set<String> keys = map.keySet();
		for(String s : keys) {
			System.out.println("이름 : " + s+ ",급여 : " +map.get(s) );
		}
	}
}

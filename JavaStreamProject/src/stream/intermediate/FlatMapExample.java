package stream.intermediate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		
		stream.flatMap(new Function<Integer, Stream<Integer>>(){
			@Override
			public Stream<Integer> apply(Integer t) {
				return Stream.of(t*2);
			}	
		}).peek(System.out::println);
	System.out.println("--------------------------------------------------");	
		OptionalDouble result = Employee.employees().stream().flatMapToDouble(new Function<Employee, DoubleStream>() {
			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
		}).filter(n->n>1000).reduce(new DoubleBinaryOperator() {
			@Override
			public double applyAsDouble(double left, double right) {
				System.out.println(left + "," + right);
				return left + right;//리턴 되는 값은 매개값 왼쪽 
			}
		});	
		System.out.println("합계 + " + result);
		
		if(result.isPresent())//존재하는지 있는지 없는지
 			System.out.println("result : " + result);
		else
			System.out.println("결과 없음");
		System.out.println("-------------------------------------------------");
		Employee.employees().stream().flatMap(new Function<Employee,Stream<String>>() {
			@Override
			public Stream<String> apply(Employee t) {
				return Stream.of(t.getName());
			}
		}).forEach(System.out::println);
	System.out.println("-------------------------------------------------------");
	Optional<LocalDate> result2 = Employee.employees().stream().flatMap(new Function<Employee, Stream<LocalDate>>() {
		@Override
		public Stream<LocalDate> apply(Employee t) {
				return Stream.of(t.getDateOfBirth());
		}
	}).reduce(new BinaryOperator<LocalDate>() {
		@Override
		public LocalDate apply(LocalDate t, LocalDate u) {
			System.out.println(t+ " , " + u);
			return t.isAfter(u)? t:u;
		}
	});
	System.out.println("값 : " + result2.get());
	}
}

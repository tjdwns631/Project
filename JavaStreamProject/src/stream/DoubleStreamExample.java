package stream;

import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DoubleStreamExample {
	public static void main(String[] args) {
		double[] dAry= {2.3, 4.5, 8.3, 5.5, 4.6};
		DoubleStream ds = Arrays.stream(dAry);
		float sum = (float) ds.filter(v -> v<5)
		.sum();
		System.out.println("5 이상 총합 : " + sum);
	
		double sum1 = Arrays.stream(dAry).filter(new DoublePredicate() {
			@Override
			public boolean test(double value) {
				return value < 5;
			}
		}).sum();
		System.out.println(sum1);
		
		LongStream ls=Arrays.stream(new long[] {10,29,38});
		IntStream is=Arrays.stream(new int[] {1,2,3});
		DoubleStream ds1=Arrays.stream(new double[] {1.1,2.2});
		
		Stream<String>sStream =Arrays.stream(new String[] {"h","s","g"});
		Stream<Student>tStream =Arrays.stream(new Student[] {new Student("동",10)});

	}
}

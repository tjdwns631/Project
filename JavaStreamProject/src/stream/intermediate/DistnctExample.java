package stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class DistnctExample {
	public static void main(String[] args) {
//		String[] strAry = {"aong","song","gong","jong","hong"};
//		Stream<String> ss = Arrays.stream(strAry);
	//	ss.distinct().forEach(System.out::println);
	//  중복 값은 걸려줌 distinct
//	   ss = Arrays.stream(strAry);
//	   ss.sorted().forEach(System.out::println);
		// 정렬 
		
		Student[] students = {new Student("허성준", 100),
							  new Student("최재영",50),
							  new Student("동광희",50),
							  new Student("김현동",70),
							  new Student("김시무",70),
							  new Student("허성준", 100),
							  new Student("허성준", 90)};
		Stream<Student> ts = Arrays.stream(students);
	//	ts.distinct().forEach(System.out::println);
	//	ts.sorted().forEach(System.out::println);
		ts.sorted(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score;
			}})
		.forEach(System.out::println);
	}
}

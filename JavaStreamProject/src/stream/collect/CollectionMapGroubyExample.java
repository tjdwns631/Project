package stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMapGroubyExample {
	public static void main(String[] args) {
		Student s1 = new Student("허성준", 25, Gender.MALE);
		Student s2 = new Student("최형준", 27, Gender.MALE);
		Student s3 = new Student("문선애", 29, Gender.FEMALE);
		Student s4 = new Student("문선애", 31, Gender.FEMALE);
		List<Student> students = Arrays.asList(s1, s2, s3 ,s4);
		
		Map<Gender, List<Student>> map;
		
//		Gender.MALE - Student1, Student2; 
//		Gender.FEMALE - Student3, Student5; 
		
		Map<Gender ,List<Student>> gMap = students.stream()
		.collect(Collectors.groupingBy(new Function<Student,Gender>() {
			@Override
			public Gender apply(Student t) {
				return t.gender;
			}
		}, Collectors.toList()));
		
		Set<Gender> set = gMap.keySet();
		for(Gender g : set) {
			System.out.println(g);
			List<Student> list = gMap.get(g);
			for(Student s : list) {
			System.out.println(s.name+"," + s.age);	
			}
		}
		
	}
}

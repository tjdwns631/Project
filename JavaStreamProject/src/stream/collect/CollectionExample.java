package stream.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import stream.intermediate.Student;

public interface CollectionExample {
	public static void main(String[] args) {
		Set<String> setStr = new HashSet<>();
		setStr.add(new String("최재영"));
		setStr.add(new String("민해주"));
		setStr.add(new String("김상민"));
		
		Iterator<String> iter= setStr.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("----------------------");
		
		List<Student> student = new ArrayList<>();
		student.add(new Student("허성준",80));
		student.add(new Student("최형준",90));
		
		for(Student s : student) {
			System.out.println(s);
		}
		System.out.println("-------------------------");
		List<Student> studentw = new ArrayList<>();
		student.add(new Student("김다희",80));
		student.add(new Student("김도은",90));
		
		Map<String, Integer> map = new HashMap<>();
		map.put("동광희", 25);
		map.put("김시무", 26);
		
		List<Student> studentr = new ArrayList<>();
		student.add(new Student("김현동",20));
		student.add(new Student("최재영",30));
		
		
		Set<String> key =  map.keySet();
	    Iterator<String> itr = key.iterator();
		while(itr.hasNext()) {
			String k =itr.next();//key값을 가지고
			System.out.println(map.get(k));//value값을 가지고
		}
		System.out.println("-----------------------------------");
		Map<String, List<Student>> stMap = new HashMap<>();
		stMap.put("남자", student);
		stMap.put("여자", studentw);
		stMap.put("재평가", studentr);
		
		Set<String> setk = stMap.keySet();
		for(String s : setk) {
	      System.out.println(s);
			if(key.equals("재평가")) {
				System.out.println(s);
			}
			
//			List<Student> valueList = stMap.get(s);
//			for(Student st : valueList) {
//				System.out.println(st);
//			}
		}
		
	}
}

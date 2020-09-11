package stream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		//컬렉션 => 외부반복자
		List<String> users = Arrays.asList("홍길동" , "최재영", "민해주", "김상민");
		
		System.out.println("외부반복자 사용");
		Iterator<String> iter = users.iterator();// iterator 반복자
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str.toString());
		}
		//스트림 => 내부반복자
//		System.out.println("내부반복자 사용");
//		Stream<String> streams = users.stream();
//		streams.forEach(new Consumer<String>() {//매개값을 받아서 리턴해주는값이 없음
//			@Override
//			public void accept(String t) {
//				System.out.println(t.toString());
//				
//			}
//		});	
		System.out.println("내부반복자 사용");//람다 표현식
		Stream<String> streams = users.stream();
		streams.forEach((t)-> System.out.println(t.toString()));
		//streams들어 잇는 값들을 반복적으로 처리 
	}
}

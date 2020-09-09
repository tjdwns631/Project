package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntExample {
	public static void main(String[] args) {
		int[] Ary= {1,2,3,4,5,6,7,8,9,10};
		//1~10까지 정수형 배열
		IntStream is = Arrays.stream(Ary);//스트림생성
		int sum = is.filter(s-> s%2 == 0)//fileter로 짝수값만
		.sum();
		System.out.println("짝수 총합 : " + sum);
		
		IntStream.range(1,10).forEach(s->System.out.println(s));
		//1부터 시작해서 9까지 
		System.out.println("-----------------------");
		IntStream.rangeClosed(1,10).forEach(d->System.out.println(d));
		//1부터10까지 다나옴
		System.out.println("-----------------------");
		IntStream.rangeClosed(1,10).filter(n-> n>5)
		.forEach(System.out::println);
		
		
		
;
	}
}

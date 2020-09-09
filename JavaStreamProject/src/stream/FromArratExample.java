package stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FromArratExample {
public static void main(String[] args) {
	int[]intAry = {3,6,9,4,7};
	IntStream is = Arrays.stream(intAry);//
//	is.filter(new IntPredicate() {
//		@Override
//		public boolean test(int value) {
//			return value >5;      //5보다 큰값만
//		}
//	}).forEach(new IntConsumer() {//반복해서
//		@Override
//		public void accept(int value) {
//			System.out.println(value);
//		}
//	});
	is.filter(value ->value >5)//5보다 큰값만
	.forEach(value-> System.out.println(value));//반복
		
     is = Arrays.stream(intAry);
     long cnt = is.count();//sum 총합
     System.out.println("cnt : " + cnt);
     
     is = Arrays.stream(intAry, 0, 4);// 1번쨰 부터 시작해서보여주고 4번째껀 x
     cnt = is.peek(t -> System.out.println(t)).count();  
     System.out.println("cnt: " +cnt  );	
}
}

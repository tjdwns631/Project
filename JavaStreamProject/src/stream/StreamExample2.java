package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Student { // 클래스 선언
   String name;
   int score;
   public Student(String name, int score) {
      this.name = name;
      this.score = score;
   }
   public String getName() { return name;}
   public int getScore() {return score;}
}
public class StreamExample2 {

   public static void main(String[] args) {
      // 최재영, 90/ 민해주, 88/ 김상민, 83/ 최형준, 86
      // score => 85 몇명인지? rCnt 변수에 담아주기.
      // 출력.
      List<Student> list = Arrays.asList(
            new Student("최재영", 90),
            new Student("민해주", 88),
            new Student("김상민", 83),
            new Student("최형준", 86));
      
      Stream<Student> students = list.stream(); // students에 list 담김
      long iCnt = 0; 
      students.filter(new Predicate<Student>() { //Predicate 매갯값을 받아서 boolean타입으로 리턴

         @Override
         public boolean test(Student t) {
            return t.score >= 85; //참인값만 peek로 보냄
         }
         
      }).peek(new Consumer<Student>() { //consumer타입의 구현할 익명개체 만듦 (만족하면 출력으로 보냄)
         @Override
         public void accept(Student t) {
             System.out.println(t.name + ", " + t.score); //출력
         }
      }).count(); //count가 하나씩 최종집계
      System.out.println("총인원: " + iCnt);
   }
}
// 람다식
//       Stream<Student> students = list.stream(); 
//       long iCnt = 0;
//       students.filter((t) -> t.score >=85) { 
//            .peek((t) -> System.out.println("peek => " + t.name + ", " + t.score);
//            .filter(t -> t.name/startsWith("최"))
////            .count();
//            .forEach(new Consumer<Student>() {
//               @Override
//               public void accept(Student t) {
//                  System.out.println("forEach=> " + t.name + ", " + t.score);
//               }
//                   System.out.println("총인원: " + iCnt);
//            }
//         }
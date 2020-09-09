package stream.intermediate;

import java.util.Objects;

public class Student implements Comparable<Student> {
	String name;
	int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public int hashCode() {
	//	return this.score; 점수가 같을떄
		return Objects.hashCode(this.name) + this.score;
		//타입다를떄
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student that = (Student)obj;
			return this.name.equals(that.name)&&
					this.score==that.score;
			}else{
				return false;
			}
	}
	@Override
	public String toString() {
		return "Student [name=" + this.name + ", score=" + this.score + "]";
	}
	@Override
	public int compareTo(Student that) {
		return this.score - that.score;//음수값이면 오름차순 양수값이면 내림차순
	}
	
}

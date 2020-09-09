package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileExample {
	public static void main(String[] args) {
		String file = "src/stream/FromArratExample.java";//경로  최상위위치project
		Path path = Paths.get(file);// 파일읽어오기  (예외처리해줘야함)
	try {
		Stream<String> stream = Files.lines(path);
		stream.forEach(s -> System.out.println(s));
		stream.close(); //소스를 반환
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//
	
	}
}

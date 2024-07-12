package example.day02.springwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }



}
/*

    서로 다른 클래스들 간의 멤소드를 호출하는 방법

    [1~3까지 static x -4번은 static.]
    1.인스턴스 생성해서 메소드 호출
     클래스명 변수명 =new 생성자명()
        변수명.메소드명();

    2.인스턴스 생성 후 메소드 호출
     new 생성자명.메소드명();

    3. [싱글톤] 미리 인스턴스 만들고 미리 만든 인스턴스 호출 후 메소드 호출
    클래스명.getInstance().메소드명(); //getInstance는 static임 나머지는 아님.

    4. 메소드 가 static으로 선언되었을 때,
    클래스명.메소드명();


 */

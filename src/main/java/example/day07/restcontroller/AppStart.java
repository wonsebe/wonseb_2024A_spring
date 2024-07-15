package example.day07.restcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


@SpringBootApplication
//1. 내장톰캣 ( 웹서버) 실행,
//2. 동일패키지 또는 하위 패키지들의 mvc어노테이션(@Controller)들을 사용하는 클래스들을 스캔해서 빈 등록 (상위패키지 스캔불가능)
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);

    }
}

package example.day08.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
@SpringBootApplication
public class AppStart{
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class);
    }

}
//public class AppStart {
//
////    // [1] Console 일때 Controller+Dao 테스트
////    public static void main(String[] args) {
////        // 1. 할일 등록
////        TodoController.getInstance().todoCreate("파이썬공부");
////        // 2. 할일 전체 출력
////        ArrayList<TodoDto> result = TodoController.getInstance().todoReadAll();
////        System.out.println( result );
////        // 3. 할일 (상태) 수정
////        TodoController.getInstance().todoUpdate(3);
////        // 4. 할일 삭제
////        TodoController.getInstance().todoDelete( 2 );
////    }
//}

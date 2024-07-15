package example.day08.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //해당 클래스가 스프링MVC 패턴에서 controller 역할, 스프링 컨테이너(저장소) 빈 (객체) 등록
public class TodoController {

    // [1] 싱글톤 패턴 : JVM 메소드 영역에 static 변수에 객체주소값 저장
//    private static TodoController todoController = new TodoController();
//    private TodoController(){ }
//    public static TodoController getInstance( ){ return todoController;  }

    @PostMapping("/todo/create")
    // 1. 할일 등록
    public boolean todoCreate( String tcontent ){
        boolean result = TodoDao.getInstance().todoCreate( tcontent );
        return result;
    }
    @GetMapping("/todo/readall")
    // 2. 할일 전체 출력
    public ArrayList<TodoDto> todoReadAll( ){
        ArrayList<TodoDto> result = TodoDao.getInstance().todoReadAll();
        return result;
    }
    @PutMapping("/todo/update")
    // 3. 할일 (상태) 수정
    public boolean todoUpdate( int tno ){
        boolean result = TodoDao.getInstance().todoUpdate( tno );
        return result;
    }
    @DeleteMapping("/todo/delete")
    // 4. 할일 삭제
    public boolean todoDelete( int tno ){
        boolean result = TodoDao.getInstance().todoDelete( tno );
        return result;
    }
}

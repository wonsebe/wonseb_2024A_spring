package example.day09.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //해당 클래스가 스프링MVC 패턴에서 controller 역할, 스프링 컨테이너(저장소) 빈 (객체) 등록
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping("/todo/create")
    // 1. 할일 등록
    public boolean todoCreate( String tcontent ){
        boolean result = todoService.todoCreate(tcontent);
        return result;
    }
    @GetMapping("/todo/readall")
    // 2. 할일 전체 출력
    public ArrayList<TodoDto> todoReadAll( ){
        ArrayList<TodoDto> result = todoService.todoReadAll();
        return result;
    }
    @PutMapping("/todo/update")
    // 3. 할일 (상태) 수정
    public boolean todoUpdate( int tno ){
        boolean result = todoService.todoUpdate(tno);
        return result;
    }
    @DeleteMapping("/todo/delete")
    // 4. 할일 삭제
    public boolean todoDelete( int tno ){
        boolean result = todoService.todoDelete(tno);
        return result;
    }
}

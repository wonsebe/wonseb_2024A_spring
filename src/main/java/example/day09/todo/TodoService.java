package example.day09.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    // 1. 할일 등록
    public boolean todoCreate( String tcontent ){
        boolean result = todoDao.todoCreate(tcontent);
        return result;
    }

    // 2. 할일 전체 출력
    public ArrayList<TodoDto> todoReadAll( ){
        ArrayList<TodoDto> result = todoDao.todoReadAll();
        return result;
    }

    // 3. 할일 (상태) 수정
    public boolean todoUpdate( int tno ){
        boolean result = todoDao.todoUpdate(tno);
        return result;
    }

    // 4. 할일 삭제
    public boolean todoDelete( int tno ){
        boolean result = todoDao.todoDelete(tno);
        return result;
    }
}

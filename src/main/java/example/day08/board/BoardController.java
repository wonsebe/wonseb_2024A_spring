package example.day08.board;

import example.day08.todo.TodoDao;
import example.day08.todo.TodoDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {

//    private static BoardController bController = new BoardController();
//   private BoardController(){ }
//   public static BoardController getInstance( ){ return bController;  }

    //게시판생성
    @PostMapping("/board/create")
    public boolean bCreate(String btitle, String bcontent , String bpw){
       BoardDto boardDto = new BoardDto();
        boardDto.setBtitle(btitle);
        boardDto.setBcontent(bcontent);
        boardDto.setBpw(bpw);

        boolean result = BoardDao.getInstance().bCreate(boardDto);
        return result;
    }
    @GetMapping("/board/printall")
    //모든글출력
    public ArrayList<BoardDto> bPrintAll(){
        ArrayList<BoardDto> result = BoardDao.getInstance().bPrintAll();
        return result;
    }
    // 상세글 출력
    @GetMapping("/board/print")
    public BoardDto bPrint(int bno){
        //int bno = 3;
        BoardDto boardDto = BoardDao.getInstance().bPrint(bno);
        return boardDto;
    }
    //글수정
    @PutMapping("/board/update")
    public boolean bUpdate(int bno , String bpw , String bcontent){
//        String pwd = "qwe1";
//        String newContent = "new";
//        int bno = 1;
        boolean result = BoardDao.getInstance().confirmPwd(bno , bpw );
        if(result==false){
            return false;
        }else{
            boolean result2 = BoardDao.getInstance().bUpdate(bno ,bcontent);
            if(result2){
                return true;
            }
        }
        return false;
    }

    //글삭제
    @DeleteMapping("/board/delete")
    public boolean bDelete(int bno , String bpw){
//        String pwd = "1234";
//        int bno = 2;
        boolean result = BoardDao.getInstance().confirmPwd(bno , bpw);
        if(result){
            boolean result2 = BoardDao.getInstance().bDelete(bno);
            if(result2){
                return true;
            }
        }
        return false;
    }
}

package example.day09.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

//    private static BoardController bController = new BoardController();
//   private BoardController(){ }
//   public static BoardController getInstance( ){ return bController;  }

    //게시판생성
    @PostMapping("/board/create")
    public boolean bCreate(String btitle, String bcontent , String bpw){
        return boardService.bCreate(btitle , bcontent , bpw);

    }
    @GetMapping("/board/printall")
    //모든글출력
    public ArrayList<BoardDto> bPrintAll(){
        ArrayList<BoardDto> result = boardService.bPrintAll();
        return result;
    }
    // 3. 게시판 상세 출력
    @GetMapping("/board/print")
    public BoardDto bPrint(int bno){
        // 해당 게시물 조회 수 처리

        BoardDto boardDto = boardService.bPrint(bno);
        return boardDto;
    }   // boardPrint() end
    //글수정
    @PutMapping("/board/update")
    public boolean bUpdate(int bno , String bpw , String bcontent){
//        String pwd = "qwe1";
//        String newContent = "new";
//        int bno = 1;
        return boardService.bUpdate(bno ,bpw , bcontent);

    }

    //글삭제
    @DeleteMapping("/board/delete")
    public boolean bDelete(int bno , String bpw) {
//        String pwd = "1234";
//        int bno = 2;

        return boardService.bDelete(bno, bpw);

    }
}

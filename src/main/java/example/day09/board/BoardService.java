package example.day09.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    //게시판생성
    public boolean bCreate(String btitle, String bcontent , String bpw){
        BoardDto boardDto = new BoardDto();
        boardDto.setBtitle(btitle);
        boardDto.setBcontent(bcontent);
        boardDto.setBpw(bpw);

        boolean result = boardDao.bCreate(boardDto);
        return result;
    }
    //모든글출력
    public ArrayList<BoardDto> bPrintAll(){
        ArrayList<BoardDto> result = boardDao.bPrintAll();
        return result;
    }
    // 3. 게시판 상세 출력
    public BoardDto bPrint(int bno){
        // 해당 게시물 조회 수 처리
        boardDao.viewIncrease(bno);
        BoardDto boardDto = boardDao.bPrint(bno);
        return boardDto;
    }   // boardPrint() end
    //글수정
    public boolean bUpdate(int bno , String bpw , String bcontent){
//        String pwd = "qwe1";
//        String newContent = "new";
//        int bno = 1;
        boolean result = boardDao.confirmPwd(bno , bpw );
        if(result==false){
            return false;
        }else{
            boolean result2 = boardDao.bUpdate(bno ,bcontent);
            if(result2){
                return true;
            }
        }
        return false;
    }

    //글삭제
    public boolean bDelete(int bno , String bpw){
//        String pwd = "1234";
//        int bno = 2;
        boolean result = boardDao.confirmPwd(bno , bpw);
        if(result){
            boolean result2 = boardDao.bDelete(bno);
            if(result2){
                return true;
            }
        }
        return false;
    }


}

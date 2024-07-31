package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.BoardDto;
import web.model.dto.BoardPageDto;
import web.service.BoardService;
import web.service.MemberService;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;
    // 2. 글 쓰기 처리
    @PostMapping("/write")
    // { "bcno" : 1 ,  "btitle" : "안녕" ,  "bcontent" : "하하하" }
    public boolean bWrite( BoardDto boardDto) {
        System.out.println("BoardController.bWrite");
        System.out.println("boardDto = " + boardDto);
        return boardService.bWrite( boardDto );
    }
//   // 오류 난거
//         @PostMapping("/write")
//        public  boolean post( BoardDto boardDto){
//            System.out.println("BoardController.post");
//            System.out.println("boardDto = " + boardDto);
//            return boardService.post( boardDto );
//        }
//        //글쓰기
//        @PostMapping("/post")
//        public boolean post(@RequestBody Map<String , String> map ){
//            return boardService.post(map);
//        }

    //글 전체 호출
    @GetMapping("/call")
    public BoardPageDto all(BoardPageDto pageDto){
        //page : 페이징 처리 에서 사용할 현재 페이지 번호
        //2. bcno : 현재 선택된 카테고리 번호
        //3.searchKey :검색 조회시 사용되는 필드명
        //4.searchKeyword: 검색 조회시 사용되는 필드의값
        return  boardService.all(pageDto);

    }
    //글 상세 호출
    @GetMapping("/detail")
    public BoardDto detailcall(int bno){
        return  boardService.detailcall(bno);
    }
    //글 수정
    @PutMapping("/load")
    public boolean Bupdate(BoardDto boardDto){
        return boardService.Bupdate(boardDto);
    }
    //글 삭제
//    @DeleteMapping("/delete")
//    public boolean Bdelete(BoardDto boardDto){
//        return boardService.Bdelete(boardDto);
//    }
    //카테고리 호출
    @GetMapping("/category")
    public ArrayList<BoardDto> bCategory(){
        return boardService.category();
    }


}

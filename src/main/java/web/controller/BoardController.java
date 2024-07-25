package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.BoardDto;
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
    public ArrayList<BoardDto> all(){
        return  boardService.all();

    }
    //글 상세 호출
    @GetMapping("/board/detail")
    public ArrayList<BoardDto>detailcall(){
        return  boardService.detailcall();
    }
    //글 수정

    //글 삭제

    //카테고리 호출
    @GetMapping("/category")
    public ArrayList<BoardDto> bCategory(){
        return boardService.category();
    }

}

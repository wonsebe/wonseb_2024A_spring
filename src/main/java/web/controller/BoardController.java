package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.BoardDto;
import web.service.BoardService;
import web.service.MemberService;

import java.util.ArrayList;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    //글쓰기

    //글 전체 호출
    @GetMapping("/call")
    public ArrayList<BoardDto> all(){
        return  boardService.all();

    }
    //글 상세 호출

    //글 수정

    //글 삭제

    //카테고리 호출
    @GetMapping("/category")
    public ArrayList<BoardDto> bCategory(){

        return boardService.category();
    }

}

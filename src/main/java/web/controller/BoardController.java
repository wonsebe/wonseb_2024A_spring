package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.BoardService;
import web.service.MemberService;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    //글쓰기

    //글 전체 호출

    //글 상세 호출

    //글 수정

    //글 삭제

    //카테고리 호출
}

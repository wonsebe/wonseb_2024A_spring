package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.BoardDao;
import web.model.dao.MemberDao;
import web.model.dto.BoardDto;

import java.util.ArrayList;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    //글쓰기

    //글 전체 호출

    //글 상세 호출

    //글 수정

    //글 삭제

    //카테고리 호출
    public ArrayList<BoardDto> category(){

        return boardDao.category();
    }
}

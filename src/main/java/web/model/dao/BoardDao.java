package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

@Component
public class BoardDao extends Dao {


    //글쓰기

    //글 전체 호출

    //글 상세 호출

    //글 수정

    //글 삭제

    //카테고리 호출
    public ArrayList<BoardDto> category(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from bcategory";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int bcno = rs.getInt("bcno");
                String bcname = rs.getString("bcname");

                BoardDto boardDto = new BoardDto();
                boardDto.setBcno(bcno);
                boardDto.setBcname(bcname);
                list.add(boardDto);
            }
        }catch (Exception e){ System.out.println(e);  }
        return list;
    }
}

package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class BoardDao extends Dao {

    //쓰기
    public boolean bWrite( BoardDto boardDto) {
        System.out.println("BoardDao.bWrite");
        System.out.println("boardDto = " + boardDto);
        try {
            String sql ="insert into board( bcno , btitle , bcontent , no , bfile ) " +
                    " values( ? , ? , ? , ? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong( 1, boardDto.getBcno() );
            ps.setString( 2 , boardDto.getBtitle() );
            ps.setString( 3 , boardDto.getBcontent() );
            ps.setLong( 4 ,  boardDto.getNo() );
            ps.setString( 5 , boardDto.getBfile() );
            int count = ps.executeUpdate();
            if( count == 1 )return true;
        }catch (Exception e ){   System.out.println(e); }
        return false;
    }
//
//    public boolean post(BoardDto boardDto){
//        System.out.println("BoardDao.bWrite");
//        System.out.println("boardDto = " + boardDto);
//        try {
//            String sql ="insert into board(bcno,btitle, bcontent, no, bfile) values(? ,? , ? ,? , ?)";
//            PreparedStatement ps=conn.prepareStatement(sql);
//            ps.setLong(1, boardDto.getBcno());
//            ps.setString(2, boardDto.getBtitle());
//            ps.setString(3, boardDto.getBcontent());
//            ps.setLong(4,boardDto.getNo());
//            ps.setString(5,boardDto.getBfile());
//            int count = ps.executeUpdate();
//            if (count ==1)return true;
//        }catch (Exception e){
//            System.out.println(e);
//        }return false;
//    }



//    //글쓰기
//    public boolean post(Map<String , String> map){
//        try{
//            String sql = "insert into board(btitle, bcontent, bcno,no) values(?,?,?,?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,map.get("btitle"));
//            ps.setString(2,map.get("bcontent"));
//            ps.setString(3,map.get("bcno"));
//            ps.setInt(4,Integer.parseInt(map.get("no")));
//
//            int count = ps.executeUpdate();
//            if(count == 1){
//                return true;
//            }
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return false;
//    }

    //글 전체 호출
    public ArrayList<BoardDto> all(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql="select *from board join member on board.no = member.no";
            // ***** 다른 필드가 필요할 때는 join 을 사용한다. ***** //
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int bno = rs.getInt("bno");
                String btitle = rs.getString("btitle");
                String id = rs.getString("id");
                String bdate = rs.getString("bdate");
                long bview = rs.getLong("bview");

                BoardDto boardDto = new BoardDto();
                boardDto.setBno(bno);
                boardDto.setBtitle(btitle);
                boardDto.setId(id);
                boardDto.setBdate(bdate);
                boardDto.setBview(bview);
                list.add(boardDto);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    //글 상세 호출

    public BoardDto detailcall(int bno){
        System.out.println("BoardDao.bFindBno");System.out.println("bno = " + bno);
        try {
            String sql = "select bc.bcno , bcname , bno  , btitle, bcontent  , id  ,bdate  , bview , bfile from board b inner join member m inner join bcategory bc on b.no = m.no and b.bcno= bc.bcno where b.bno=?;";
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt( 1 , bno );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                BoardDto boardDto = BoardDto.builder()
                .bcno(rs.getInt("bcno"))
                .bno(rs.getInt("bno"))
                 .bcname(rs.getString("bcname"))
                .btitle(rs.getString("btitle"))
                .bcontent(rs.getString("bcontent"))
                .id(rs.getString("id"))
                .bdate(rs.getString("bdate"))
                .bview(rs.getInt("bview"))
                 .bfile(rs.getString("bfile"))
                .build();
                return boardDto;
            }
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return null;
    }

    //글 수정

    //글 삭제




//    //카테고리 호출 :  강사님 코드
//    public Map<String, String > category(){
//        System.out.println("BoardDao.category");
//        //list 컬렉션 선언 , map컬렉션(객체) 을 여러개 저장하기 위해 list 선언
//        //-map 컬렉션 선언
//        System.out.println("1번통과");
//        Map<String ,String > map =new HashMap<>();
//        System.out.println("2번통과");
//        try {
//            String sql ="select * from bcategory";
//            System.out.println("3번통과");
//            PreparedStatement ps =conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            System.out.println("4번통과");
//            while (rs.next()){
//                //map 컬렉션 엔트리 추가
//                    //엔트리 : 키: 값으로 구성된 객체 표현 (2개) 카테고리 번호, 카테고리 이름
//                map.put("bcno" , String.valueOf(rs.getInt(1)) );
//                map.put("bcname" , String.valueOf(rs.getString(2)) );
//                //-map 컬렉션/객체를 리스트/객체에 담기
//
//                System.out.println(map);
//            }
//            System.out.println("5번통과");
//        }catch (Exception e){
//            System.out.println(e);
//            System.out.println("6번통과");
//        }
//        return null;
//    }

    //우리가 짠 코드
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

package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

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
    //****** 3-2 전체 게시물 수 반환 처리 , 조건추가1) 카테고리
    public int getTotalBoardSize(int bcno , String searchKey , String searchKeyword){
        try {
            String sql ="select count(*) as 총게시물수 from board inner join member on board.no= member.no";

            //카테고리가 존재하면 , 0: 카테고리없다는 의미. 1 이상: 카테고리의 pk 번호
            if (bcno >0){
                sql += " where bcno = " +bcno;
            }
            //검색이 존재했을 떄 , keyword 가 존재하면
            if (searchKeyword.isEmpty()){} //문자열이 비어있으면 , 검색이 없다라는 의미의 뜻으로 활용
            else {//비어있지 않으면 , 검색이 있다라는 의미의 뜻
                //카테고리가 있을 때는 end 추가
            if (bcno >=1){sql += " and ";}
                //카테고리가 없을 떄[전체검색]는 where 추가
            else { sql += " where ";}
                //검색 sql
                sql += searchKey +" like '%"+searchKeyword+"%' ";

            }
            System.out.println(" sql : " + sql);

                //1. 전체보기 : select count(*) as 총게시물수 from board
                //2. 카테고리 보기 : select count(*) as 총게시물수 from board where bcno = 숫자



            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1); //총 게시물 수
            }

        }catch (Exception e){
            System.out.println(e);
        }return 0;

    }
    // 3. 글 전체 호출
    public List<BoardDto> all(int startLow , int pageBoardSize ,int bcno , String searchKey , String searchKeyword){
        List<BoardDto> list = new ArrayList<>();
        try{ String sql = "select * " +
                    //1. 조회
                "  from board inner join member " +
                    //2. 조인 테이블
                "  on board.no = member.no " ;
                    //3. 조인 조건

                     //4. 일반조건
                        //- 전체보기 이면 where 절 생략 , bcno =0 이면
                        // -카테고리별 이면 whre 절 추가 , bcno >= 1 이상
                if (bcno>=1){ sql += "  where bcno= "+ bcno; }

                //4. 일반조건 2
                if (searchKeyword.isEmpty()){}
                else {
                    if (bcno >= 1) {sql +=" end ";}
                    else {sql += "  where " ; }
                    sql += searchKey + "  like '%"+searchKeyword+"%'" ;
                }
                //정렬조건 , 내림차순
                sql += "  order by board.bno desc " ;
                    //5. 정렬 , 내림차순
                sql += "  limit ? , ? ";
                    //6. 레코드 제한 , 페이징처리

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1 , startLow );
            ps.setInt( 2 , pageBoardSize );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                // 레코드 를 하나씩 조회해서 Dto vs Map 컬렉션
                BoardDto boardDto = BoardDto.builder()
                        .bno( rs.getInt("bno") )
                        .btitle( rs.getString("btitle") )
                        .id( rs.getString("id") )
                        .bdate( rs.getString("bdate") )
                        .bview( rs.getInt("bview") )
                        .build();
                list.add( boardDto );
            }
        }catch (Exception e ){  System.out.println(e); }
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

    //5. 조회수 증가 처리
    public boolean viewIncrease(int bno){
        try {
            String sql ="update board set bview =bview +1 where bno= ?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, bno);
            int count = ps.executeUpdate();
            if (count==1)return  true;
        }catch (Exception e){
            System.out.println(e);
        }
        return  false;

    }

    //글 수정
    public boolean Bupdate(BoardDto boardDto){
        try {
            String sql= " update board set  btitle= ? , bcontent= ? , bcno= ?  where bno =?" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardDto.getBtitle());
            ps.setString(2,boardDto.getBcontent());
            ps.setLong(3,boardDto.getBcno());
            ps.setLong(4,boardDto.getNo());
            int count = ps.executeUpdate();
            if( count == 1 )return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    //글 삭제
//    public boolean Bdelete(BoardDto boardDto){
//        try {
//            String sql ="delete from board where bno =?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(2,boardDto.getBno());
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }




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

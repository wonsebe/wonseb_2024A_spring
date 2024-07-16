package example.day09.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class BoardDao {





    private BoardDao(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/board" , "root","1234");
        }catch (Exception e ){  System.out.println( e );  }
    }
    private Connection conn; private PreparedStatement ps; private ResultSet rs;

    //게시판생성
    public boolean bCreate(BoardDto boardDto){
        try{ String sql ="insert into board(btitle,bcontent,bpw) values(?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString( 1 , boardDto.getBtitle()  );
            ps.setString(2, boardDto.getBcontent());
            ps.setString(3, boardDto.getBpw());
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        }catch (Exception e ){  System.out.println( e );   }
        return false;
    }
    //모든글출력
    public ArrayList<BoardDto> bPrintAll(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while ( rs.next() ){
                BoardDto boardDto = new BoardDto(
                        rs.getInt("bno"),
                        rs.getString("bdate"),
                        rs.getString("btitle"),
                        rs.getString("bcontent"),
                        rs.getInt("bview"),
                        rs.getString("bpw")
                );
                list.add( boardDto );
            }
        }catch (Exception e){ System.out.println(e);
        }
        return list;
    }
    // 상세글출력
    public BoardDto bPrint(int bno){
        BoardDto boardDto = new BoardDto();
        try{
            String sql = "select * from board where bno = '"+bno+"'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                boardDto.setBno(rs.getInt("bno"));
                boardDto.setBtitle(rs.getString("btitle"));
                boardDto.setBcontent(rs.getString("bcontent"));
                boardDto.setBdate(rs.getString("bdate"));
                boardDto.setBview(rs.getInt("bview"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return boardDto;
    }
    // 비밀번호 확인
    public boolean confirmPwd(int bno , String confirmPwd){
        try{
            String sql = "select * from board where bno = ? and bpw = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            ps.setString(2,confirmPwd);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // confirmPwd end
    //글수정
    public boolean bUpdate(int bno , String bcontent){
        try{
            String sql = "update board set bcontent = ? where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,bcontent);
            ps.setInt(2,bno);
            int count = ps.executeUpdate();
            if(count ==1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    //글삭제
    public boolean bDelete(int bno){
        try{
            String sql = "delete from board where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if(count==1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // * 조회 수 증가 처리 함수
    public boolean viewIncrease(int bno){
        try{
            String sql = "update board set bview = bview + 1 where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1 , bno);
            int count = ps.executeUpdate();
            if(count==1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // viewIncrease() end




}

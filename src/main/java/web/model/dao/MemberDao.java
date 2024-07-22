package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class MemberDao extends Dao {
    // 1. 회원가입
    public boolean mSignup(MemberDto memberDto) {
        System.out.println("MemberDao.mSignup");
        System.out.println("memberDto = " + memberDto);
        try {
            String sql = "insert into member( id , pw , name , email , phone ) values( ? , ? , ? , ? , ? )";
            PreparedStatement ps = super.conn.prepareStatement(sql);
            ps.setString(1, memberDto.getId());
            ps.setString(2, memberDto.getPw());
            ps.setString(3, memberDto.getName());
            ps.setString(4, memberDto.getEmail());
            ps.setString(5, memberDto.getPhone());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return false;
    }

    // 2. 로그인 : 로그인 성공한 회원번호 반환( 세션에 저장할려고 )
    public int mLogin(MemberDto memberDto) {
        System.out.println("MemberDao.mLogin");
        System.out.println("memberDto = " + memberDto);
        try {
            String sql = "select * from member where id = ? and pw =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getId());
            ps.setString(2, memberDto.getPw());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("no");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0; // 0 은 회원번호가 없다 뜻
    }

    // 5. 마이페이지 정보
    public MemberDto mMyInfo(int loginMno) {
        try {
            String sql = "select * from member where no = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return MemberDto.builder()
                        .no(rs.getInt("no"))
                        .id(rs.getString("id"))
                        .phone(rs.getString("phone"))
                        .email(rs.getString("email"))
                        .name(rs.getString("name"))
                        .build();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //6. 아이디 중복검사
    public boolean mIdCheck(String id) {
        System.out.println("MemberDao.mIdCheck");
        System.out.println("id = " + id);
        try {
            String sql = "select mid from member where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { return true;}

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
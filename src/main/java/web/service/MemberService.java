package web.service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@Service
public class MemberService {

    @Autowired MemberDao memberDao;

    // 1. 회원가입
    public boolean mSignup( MemberDto memberDto ){
        System.out.println("MemberService.mSignup");
        System.out.println("memberDto = " + memberDto);
        return memberDao.mSignup( memberDto );
    }

    @Autowired // 현재 요청을 보낸 클라이언트의 HTTP 요청정보를 가지고 있는 객체를 주입
    HttpServletRequest request;

    // 2. 로그인
    public boolean mLogin( MemberDto memberDto ){
        System.out.println("MemberService.mLogin"); System.out.println("memberDto = " + memberDto);
        int result =  memberDao.mLogin( memberDto );
        if( result >= 1 ) { // 만약에 로그인 성공시
            // - 빌더패턴 : 생성자가 아닌 메소드를 이용한 방식의 객체 생성
            MemberDto loginDto = MemberDto.builder()
                    .no( result )
                    .id( memberDto.getId() )
                    .build();
            // ----- HTTP 세션 처리 ----- //
            // 1. 현재 요청을 보내온 클라이언트의 세션객체 호출
            HttpSession session = request.getSession();
            // 2. 세션객체에 속성 추가
            session.setAttribute( "loginDto", loginDto );
            return true;
        }
        return false;
    }
    // 3. 로그인의 상태 반환
    public MemberDto mLoginCheck( ){
        HttpSession session = request.getSession(); // 1. 현재 요청을 보내온 클라이언트의 세션객체호출
        // 2. 세션객체내 속성 값 호출 , 타입변환 필요하다.
        Object object = session.getAttribute( "loginDto" );
        if( object !=null ){   return (MemberDto)object;  }
        return null;
    }

    // 4. 로그아웃 : 세션 초기화
    public void mLogout( ){
        // 1. 현재 요청을 보내온 클라이언트의 세션객체호출
        HttpSession session = request.getSession();
        // 2. 세션객체내 모든 속성 값 초기화
        session.invalidate();
    }

    // 5. 마이페이지 정보
    public MemberDto mMyInfo( ){
        // 1. 로그인된 회원번호
        MemberDto loginDto = mLoginCheck(); // 로그인된 세션정보 요청
        if( loginDto == null )return null; // 비로그인이면 리턴
        int loginMno = loginDto.getNo();
        // 2.
        return memberDao.mMyInfo( loginMno );
    }

    //6. 아이디 중복검사
    public  boolean mIdCheck(String id){
        return  memberDao.mIdCheck(id);
    }

    //7. 수정페이지
    public  boolean update(MemberDto memberDto){
        return  memberDao.update(memberDto);
    }
    //8. 삭제 페이지
    public  boolean delete(String  pwConfirm){
        //현재 탈퇴하는 회원의 로그인된 번호
            //1. 로그인 세션 객체 호출
        Object object=request.getSession().getAttribute("loginDto");
            //2.
        if (object == null)return false;
        //3. 로그인 세션객체내 로그인 정보를 타입벼환
        MemberDto loginDto = (MemberDto) object; //타입변환
        //4. 로그인정보에서 회우너번호만 추출
        int loginNo= loginDto.getNo();
        //5. Dao에게 전달
        boolean result= memberDao.delete(loginNo,pwConfirm);
        //6만약 성공시 로그아웃
        if (result){mLogout();}
        return result;
    }



} // class end








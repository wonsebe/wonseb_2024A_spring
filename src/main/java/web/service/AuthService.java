package web.service;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import web.controller.AuthController;
import web.model.dao.MemberDao;

import java.util.Random;


@Service //스프링 컨테이너의 등록하고 빈(객체) 생성
public class AuthService {

@Autowired
    HttpServletRequest request; //HTTP 요청 객체* **********************
    public boolean authCode(String email){
      try {

          //인증번호 생성 :
          //인증코드가 문자인 이유 : 앞자리에 0이 들어갈 수도 있으니까(들어가야 해서)
          String authCode= "";

          //2.난수 생성 , Random 클래스
          Random random= new Random();
          //random.nextInt(); //int타입의 표현범위내 난수생성 함수
          for (int i=0; i<6; i++){
              authCode += random.nextInt(10);
          }
          System.out.println("authCode = " + authCode);

          //3. (선택)  DB: 영구적인 데이터  vs JVM(스택, 힙, 메소드)  vs  세션(요청하는 클라이언트들의 브라우저마다-웹서버 저장소)
          //1. 서버 세션 객체의 인증 코드를 저장
          request.getSession().setAttribute("authCode", authCode);
          //2. 서버 세션의 객체의 생명주기(세션이 유지되는 시간)
          request.getSession().setMaxInactiveInterval(10);
          //setMaxInactiveInterval(초): 초기준 ..10초동안 세션 유지하고 10초 후 삭제
          //3.이메일 전송 --
         // emailSend(email, " 000 홈페이지의 회원가입 인증코드", "인증코드: "+authCode);
          return  true;


      }catch (Exception e){
          System.out.println(e);
      }
        return false;
    }

    //2. 입력받은 값과 인증 번호를 인증/비교
    public  boolean authCheck(String authCodeInput){
        System.out.println("authCodeInput = " + authCodeInput);
        System.out.println("AuthService.authCheck");
        //1. 인증번호 호출
       Object object=request.getSession().getAttribute("authCode");
       if (object != null){//세션객체의 인증번호가 존재하지 않으면
           String authCode = (String) object;
           //.2. 입력받은 인증번호와 인증번호 비교
           if (authCode.equals(authCodeInput)){
               return  true;
           }
       }
       return false;
    }

    @Autowired
    JavaMailSender javaMailSender; //javamail 객체제공
    //3. 이메일 전송 함수 ,매개변수 : 받는사람 의 이메일 , 메일 제목, 메일 내용
    public void emailSend(String toEmail , String subject , String content){
        try {


            //1. 메일 내용물들을 포맥/형식 맞추기 위해 MIME
            //1.Mime 객체  생성
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //2.메일 내용 구성
            //new MimeMessageHelper(mime객체, 첨부파일여부 ,인코딩타입)
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            //3. 메일 보내는 사람
            mimeMessageHelper.setFrom("본인의 이메일");
            //4. 메일 받는 사람
            mimeMessageHelper.setTo(toEmail);
            //5. 메일 제목
            mimeMessageHelper.setSubject(subject);
            //6. 메일 내용
            mimeMessageHelper.setText(content);
            //7. *** 메일 전송
            javaMailSender.send(mimeMessage); //mime 객체를 보내기

        }catch (Exception e){
            System.out.println(e);
        }


    }


}

package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.standard.inline.StandardTextInliner;
import web.service.AuthService;

@RestController //@controller + @ResponseBody
@RequestMapping("/auth") // 해당 클래스내 메소드들의 공통 HTML URL
public class AuthController {
    @Autowired // 스프링 컨테이너의 빈(객체) 주입
    AuthService authService;

    //1. 인증번호 요청
    @GetMapping("/code")

    public boolean authCode(String  email){

        return authService.authCode(email);
    }
    //2. 입력받은 값과 인증번호를 인증/ 비교
    @PostMapping("/check")
    public boolean authCheck(String authCodeInput){
        return authService.authCheck(authCodeInput);



    }

}

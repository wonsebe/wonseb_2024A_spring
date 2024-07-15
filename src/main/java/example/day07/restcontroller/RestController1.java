package example.day07.restcontroller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

//includin RESTful :HTTP 기반의 자원을 제공하는 인터페이스 구축( CRUD)
//SPRING WEB 아닌 환경 =servlet 클래스 직접 구현, sevlet 클래스를 controller 사용
//spring web 환경 = mvc2 3티어 제공하여  controller 자동으로 서블릿 등록
@Controller //해당 클래스가 spring mvc 에서 controller 역할 클래스임을 등록, 스프링 컨테이너(전역 저장소) 빈 (객체 )등록
    //제어 역전 ( IOC ) : 객체관리를 개발자가 아닌 스프링이 해준다.
    // 왜??? 여러 개발자가 공통으로 사용할 객체는 1명이 관리하면 좋은데 그역할을 스프링이 해주기 때문
public class RestController1 {
    //@RequestMapping(value = "해당메소드할매핑할HTTP주소정의",method = RequestMethod.GET)
    //method = RequestMethod.GET


    //[1]HTTP GET
    @RequestMapping(value ="/example/rest1", method = RequestMethod.GET)
    public void getRest1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("RestController1.getRest1");
        //데이터 요청
        String key=request.getParameter("key");
        System.out.println("key = " + key);
        //데이터 응답
        response.getWriter().print("[GET]ClientHi");
    }
    //[2] HTTP POST
    @RequestMapping(value = "/example/rest1",method = RequestMethod.POST)
    public void postRest1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("RestController1.postRest1");
        //데이터 요청
        String key=request.getParameter("key");
        System.out.println("key = " + key);
        //데이터 응답
        response.getWriter().print("[GET]ClientHi");
    }

    //[3] HTTP PUT
    @RequestMapping (value = "/example/rest1", method = RequestMethod.PUT)
    public void putRest1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("RestController1.putRest1");
        //데이터 요청
        String key=request.getParameter("key");
        System.out.println("key = " + key);
        //데이터 응답
        response.getWriter().print("[GET]ClientHi");
    }

    //[4] HTTP delete
    @RequestMapping(value = "/example/rest1", method = RequestMethod.DELETE)
    public void deleteRest1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("RestController1.deleteRest1");
        //데이터 요청
        String key=request.getParameter("key");
        System.out.println("key = " + key);
        //데이터 응답
        response.getWriter().print("[GET]ClientHi");
    }

}

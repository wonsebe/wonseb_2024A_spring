package example.day06.servlet;

/*

    서블릿: 자바를 사용하여 웹 페이지를 동적으로 생성하는 서버측 프로그램
        -웹 : 서버의 성능을 향상하기 위해 사용되는 일종의 클래스
        -즉) 자바 회사에서 웹 개발을 하기 위한 웹 관련 클래스 제공한다.
        -서블릿 사용하는 방법
            1. 해당 클래스에 httpServlet 상속받는다
            2. 외부로부터 해당 클래스를 연결/매핑 할 수 있도록 HTTP url(인터넷 웹 주소)정의하기
            -해당 클래스에  @(어노테이션)
            3. HTTPServlet 의 다양한 메소드 제공
                -doGet() : HTTP 를 이용한  서버로부터 들어올 때 HTTP 의  METHOD가 GET 이면 호출되는 함수




 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/day06/servlet")

public class ServletController extends  HttpServlet {
    //extends : 상속 (해당 클래스에 특정 클래스로부터 상속받으면 해당 클래스는 특정클래스로부터 모든 필드 /메소드 상속받을 수 있다.

    //init
    @Override
    public void init() throws ServletException {
        System.out.println("ServletController.init");
        System.out.println("해당 클래스의 서블릿 객체가 생성되었다.");
        super.init();
    }

    //service
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.service");
        System.out.println("해당 클래스의 서블릿 객체 서비스가 실행되었다.");
        super.service(req, resp);
    }

    //destroy
    @Override
    public void destroy() {
        System.out.println("ServletController.destroy");
        System.out.println("해당 클래스 의 서블릿 객체가 초기화되었다.");
        super.destroy();
    }

    //1. doget 오버라이딩:  상속받은 클래스의 메소드를 재정의
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doGet");
        System.out.println("HTTP 의 get 메소드 방식으로 요청이 들어왔습니다.");
       // super.doGet(req, resp);//super.메소드//부모클래스 메소드 호출

        //- 요청데이터 : 매개변수처럼 HTTP 요청시 들어오는 데이터 , HTTP 요청정보 관련 객체 : HTTPServletRequest
        System.out.println(" request Data : "+ req.getParameter("data"));
        //-응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터 ,HTTP 요청정보 관련 객체 : HTTPServletRequest
        resp.getWriter().print("response Data : [1]clientHi");

    }
    //2. doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPost");
        System.out.println("HTTP의 Post 메소드 방식으로 요청이 들어왔습니다.");
        //super.doPost(req, resp);

        //1. 요청 데이터
        System.out.println("request Data : "+ req.getParameter("data"));
        //-응답데이터
        resp.getWriter().print("response Data : [post]clientHi");
    }
    //doPut
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPut");
        System.out.println("HTTP의 Put 메소드 방식으로 요청이 들어왔습니다.");
        //super.doPut(req, resp);

        //1. 요청 데이터
        System.out.println("request Data : "+ req.getParameter("data"));
        //-응답데이터
        resp.getWriter().print("response Data : [put]clientHi");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doDelete");
        System.out.println("HTTP의 Delete 메소드 방식으로 요청이 들어왔습니다.");
        //super.doDelete(req, resp);
        //1. 요청 데이터
        System.out.println("request Data : "+ req.getParameter("data"));
        //-응답데이터
        resp.getWriter().print("response Data : [delete] clientHi");
    }
}

package example.day06.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/day06/test")
public class TestConstroller   extends  HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("안녕");
        String s= req.getParameter("value");    // ?value=값    , 해당 값 (문자열) 호출
        int value = Integer.parseInt( s );          // 가져온 값을 정수 변환
            System.out.println( value + 2 );        // 연산
        resp.getWriter().print(value+2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("안녕");
        String s= req.getParameter("value");    // ?value=값    , 해당 값 (문자열) 호출
        int value = Integer.parseInt( s );          // 가져온 값을 정수 변환
        System.out.println( value * 2 );        // 연산
        resp.getWriter().print(value*2);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("안녕");
        String s= req.getParameter("value");    // ?value=값    , 해당 값 (문자열) 호출
        int value = Integer.parseInt( s );          // 가져온 값을 정수 변환
        System.out.println( value / 2 );        // 연산
        resp.getWriter().print(value/2);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("안녕");
        String s= req.getParameter("value");    // ?value=값    , 해당 값 (문자열) 호출
        int value = Integer.parseInt( s );          // 가져온 값을 정수 변환
        System.out.println( value % 2 );        // 연산
        resp.getWriter().print(value %2);
    }
}


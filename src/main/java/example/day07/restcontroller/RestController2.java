package example.day07.restcontroller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

@Controller
public class RestController2 {
    //[1] HTTP GET
    @RequestMapping(value = "/example/rest2", method = RequestMethod.GET)
    @ResponseBody //응답할 데이터의 타입 자동 설정 : String -> (http)text/plain; 타입을 자동으로 바꿔준다.
    public String getRest2(HttpServletRequest request) {
        System.out.println("RestController2.getRest2");
        //요청
        String key=request.getParameter("key");
        System.out.println("key = " + key);

        //응답
            //2-1 메소드의 반환타입을 정의한다.
        return "[GET] Client HI";
            //2-2 @ResponseBody 메소드 위에 정의한다.
    }
    @RequestMapping(value = "/example/rest2",method = RequestMethod.POST)
    @ResponseBody //응답할 데이터의 타입 자동 설정 : String -> (http)text/plain; 타입을 자동으로 바꿔준다.
    public ArrayList<RestDto> getPost2(HttpServletRequest request){
        System.out.println("RestController2.getPost2");
        String key= request.getParameter("key");
        System.out.println("key = " + key);

        //데이터 구성
//        ArrayList<String> strArray=new ArrayList<>();
//        strArray.add("[POST]"); strArray.add("ClientHi");
//        return strArray;
//        RestDto strArray=new RestDto("[POST]","ClientHi");
//
//        return strArray;
        //리스트 안에 DTO 타입
        ArrayList<RestDto> strArray=new ArrayList<>();
        strArray.add(new RestDto("[POST]","ClientHi"));
        strArray.add(new RestDto("[POST2]","ClientHi2"));
        return strArray;
    }

    //3. HTTP PUT
    @RequestMapping(value = "/example/rest2",method = RequestMethod.PUT)
    @ResponseBody
    public int putRest2(HttpServletRequest request){

        System.out.println("RestController2.putRest2");
        String key= request.getParameter("key");
        System.out.println("key = " + key);
        return 10+10; //application/json
    }
    @RequestMapping(value = "/example/rest2",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteRest2(HttpServletRequest request){
        System.out.println("RestController2.deleteRest2");
        String key=request.getParameter("key");
        System.out.println("key = " + key);
        return  true;
    }
}

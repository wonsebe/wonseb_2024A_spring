package example.day07.restcontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController //@Controller + @ResponseBody: 해당 클래스의 메소드들은 모두  @ResponseBody 적용
@RequestMapping(value = "/example")//컨트롤러 클래스 매핑 : 해당 클래스의 메소드들의 공통 URL 정의한다.
public class RestController3 {


    //[1] HTTP GET
    //@RequestMapping(value = "/example/rest3", method = RequestMethod.GET)
    @GetMapping("/rest3") //좀 더 깔끔함  // @GetMapping("HTTP URL 정의"): HTTP  GET 메소드의 URL 정의

    public  String  getRest3(HttpServletRequest request){
        System.out.println("RestController3.getRest3");// getRest3 잘 나오는지 확인용
        String key=request.getParameter("key");//key"라는 이름의 매개변수에 대한 값을 문자열로 가져와서 변수 key에 저장
        System.out.println("key = " + key);//key 값 출력
        return "[GET]ClientHi";//[GET]ClientHi 을 반환
    }

    //[2] HTTP POST
    @PostMapping("/rest3")

    public RestDto postRest3(HttpServletRequest request){
        System.out.println("RestController3.postRest");// postRest 잘 나오는지 확인용
        String key=request.getParameter("key"); //key"라는 이름의 매개변수에 대한 값을 문자열로 가져와서 변수 key에 저장
        System.out.println("key = " + key); //key 값 출력
        RestDto restDto=new RestDto("[post]","ClientHi"); //POST에 [post]","ClientHi 출력하게 함
        return restDto; //DTO 에 있는 정보들을 반환
    }

    //[3]PUT
    @PutMapping("/rest3")
    public int putRest3(HttpServletRequest request){ //정수형 타입
        System.out.println("RestController3.putRest3"); // putRest3이ㅣ 잘 나오는지 확인용
        String key=request.getParameter("key"); //key (문자열)값 대입
        System.out.println("key = " + key); //key 값 출력
        return 10+10; //key 값이 20이 나오도록 연산식 씀 ( 정수형)
    }

    //[4]DELETE
    @DeleteMapping ("/rest3")
    public boolean deleteRest3(HttpServletRequest request){ //반환값 true /false 나오게 타입 지정
        System.out.println("RestController3.deleteRest3");
        String key=request.getParameter("key"); //주소에 넣을 key 값을 내가 지정해서 넣어줌 (똑같이 써줘야함) + 저장
        System.out.println("key = " + key); //key 값 출력
        return true;//true 를 출력하게 함
    }

}

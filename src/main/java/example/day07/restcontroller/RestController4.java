package example.day07.restcontroller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class RestController4 {
 // ======================쿼리스트링의 매개변수들을 매핑하는 방법 ======================//
    //[1] HTTP GET
    @GetMapping("/test1")
    public String test1(HttpServletRequest request){
        System.out.println("RestController4.test1");
        String key1=request.getParameter("key1");
        System.out.println("key1 = " + key1);
        String key2=request.getParameter("key2");
        System.out.println("key2 = " + key2);
        return "test1 Hi";

    }

    //HTTP GET
    @GetMapping("/test2") //전제조건 : 쿼리스트링의 key 이름과 메소드의 매개변수명이 동일해야한다.
    public String test2(String key1, int key2){ // 메소드 명( 타입 key, 타입 key)
        System.out.println("RestController4.test2");
        System.out.println("key1 = " + key1 + ", key2 = " + key2);
        return  "test2 Hi";
    }

    @GetMapping("/test3")
    public String test3(@RequestParam("key1") String  name, @RequestParam("key2") int age){//쿼리스트링의 key 이름과 메소드의 매개변수명이 동일하지 않으면 오류
        System.out.println("RestController4.test3");
        System.out.println("name = " + name + ", age = " + age);
        return "test3 Hi";

    }

    //[4] HTTP GET
    @GetMapping("/test4")
    public String test4(RestDto restDto){//전제조건 : 쿼리스트링의 key 이름과 클래스의 멤버변수의 이름과 동일해야한다.
        System.out.println("RestController4.test4");
        System.out.println("restDto = " + restDto);
        return "test4 Hi";
    }


}

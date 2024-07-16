package example.day09.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //1.내장 톰캣 실행 2.Mvc 어노테이션들을 스캔해서 빈(객체) 등록
public class MvcSpringWeb {
    public static void main(String[] args) {
        SpringApplication.run(MvcSpringWeb.class);
    }
}
//view: resources 안에 있는 HTML, CSS, JS 파일 검색

@RestController
//@Controller
class  MvcSpringWebController{
@Autowired MvcSpringWebService service;
}

@Service
class  MvcSpringWebService{


}

@Component
class MvcSpringWebDao{
 @Autowired MvcSpringWebDao dao;

}

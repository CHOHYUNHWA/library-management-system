package rmsoft.librarymanagementsystem.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/api/test")
    public String testApi(){
        return "테스트 성공";
    }
}

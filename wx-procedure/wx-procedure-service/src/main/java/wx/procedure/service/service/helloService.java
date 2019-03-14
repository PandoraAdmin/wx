package wx.procedure.service.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloService {
    @PostMapping(value = "/hello")
    String select(@RequestParam(value = "hello")String  hello){
        System.out.println("342");
        return  hello;
    };
    @GetMapping (value = "/host")
    String host(){
        System.out.println("342");
        return "323244";
    };
}

package wx.procedure.caller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wx.procedure.caller.service.callerService;

@RestController
@RequestMapping("/")
public class hello {
    @Autowired
    callerService callerService;

    @Value("${server.port}")
    String port;
    @GetMapping("/hellor")
    public String home() {
      String t=callerService.select("qwe");
      System.out.println(t);
        return "hello world from port " + port+t;

    }
}

package wx.procedure.caller.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-service")
public interface callerService {
    @PostMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    String  select(@RequestParam(value = "hello")String  hello);
}

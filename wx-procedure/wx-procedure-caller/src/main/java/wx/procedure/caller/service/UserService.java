package wx.procedure.caller.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wx.procedure.caller.dto.User;

import java.util.Map;


@FeignClient("user-service")
public interface UserService {

    @PostMapping(value = "/user/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean userSave(@RequestBody User user);
    @PostMapping(value = "/user/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean userUpdate(@RequestBody User user);
    @PostMapping("/login")
    String login(@RequestParam(value = "password") String password,
                 @RequestParam(value = "usernames") String username);
    @PostMapping("/user/queryByusername")
    User queryByusername(@RequestParam(value = "uaername") String username);
    /**
     * 分页查询用户列表
     * @param pageNo   第几页
     * @param pageNum  页长
     * @return
     */
    @PostMapping("/user/pageList")
    Map<String,Object> pageListUser(@RequestParam(value = "pageNo") int pageNo,
                                    @RequestParam(value = "pageNum") int pageNum);
}

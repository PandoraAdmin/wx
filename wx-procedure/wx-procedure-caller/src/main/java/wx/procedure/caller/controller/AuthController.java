package wx.procedure.caller.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import wx.procedure.caller.dto.User;
import wx.procedure.caller.response.Response;
import wx.procedure.caller.service.AuthService;
import wx.procedure.caller.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author Pandora
 */
@RestController

public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "${jwt.route.authentication.path}/login")
    public Response createAuthenticationToken(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            HttpServletRequest request) throws AuthenticationException {
        String token = "";
        try {
            token = authService.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response().success(token);
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.POST)
    public Response refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        System.out.print(token);
        if (refreshedToken == null) {
            return new Response().failure("null");
        } else {
            return new Response().success(refreshedToken);
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public User register(@RequestParam(value = "id") String id,
                         @RequestParam(value = "username") String username,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "phone") String phone
    ) throws AuthenticationException {
        User addedUser = new User();
        if (null != id) addedUser.setId(id);
        if (StringUtils.isNotEmpty(password))
            addedUser.setPassword(password);
        if (StringUtils.isNotEmpty(username))
            addedUser.setName(username);
        if (StringUtils.isNotEmpty(phone))
            addedUser.setPhone(phone);
        return authService.registerOrUpdate(addedUser);
    }


    @RequestMapping(value = "auth/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.client;
    }

    /**
     * 分页查询用户列表
     *
     * @param pageNo  第几页
     * @param pageNum 页长
     * @return
     */
    @PostMapping("/user/pageListUser")
    public Response pageListUser(
            @RequestParam(value = "pageNo") int pageNo,
            @RequestParam(value = "pageNum") int pageNum) {

        Map<String, Object> map = null;
        try {
            map = userService.pageListUser(pageNo, pageNum);

        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
        System.out.println("asdsdsa");
        return new Response().success("分页查询字段用户成功", map);
    }


}

package wx.procedure.caller.service;



import wx.procedure.caller.dto.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Pandora
 */
public interface AuthService {
    User registerOrUpdate(User userToAdd);
    String login(String username, String password) throws Exception;
    String refresh(String oldToken);
}

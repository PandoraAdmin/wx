package wx.procedure.caller.secruity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wx.procedure.caller.dto.User;
import wx.procedure.caller.service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Pandora
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.queryByusername(username);
        if (null == user) {
            user = userService.queryByusername(username);
            redisTemplate.opsForValue().set("auth_user_" + username, user, 123L);
        }
      //  user.getRoleId();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + "USER");
        GrantedAuthority authority = new SimpleGrantedAuthority("PERMISSION_" + "USER");
        grantedAuthorities.add(authority);
        grantedAuthorities.add(grantedAuthority);
        //   User user= new User("admin", "$2a$10$2qGMy.VCY2btZvIh0ECtGuWHeAK17Kn2NzRFWB1fJyCIQ8Kum9qnW", grantedAuthorities);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return new JwtUser(username, user.getPassword(), grantedAuthorities);
        }
    }
}

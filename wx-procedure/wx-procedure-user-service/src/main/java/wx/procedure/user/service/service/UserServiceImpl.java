package wx.procedure.user.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wx.procedure.user.service.entity.User;
import wx.procedure.user.service.mapper.UserMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.baomidou.mybatisplus.core.toolkit.StringUtils.*;

@RestController
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {
    @Qualifier
    UserMapper userMapper;
    @PostMapping("/user/queryByusername")
    public User queryByusername(@RequestParam(value = "username") String username) {
        Map map = new HashMap<String, String>();

        QueryWrapper qw = new QueryWrapper();
        if (isNotEmpty(username)) {
            qw.eq("name", username);
            qw.or();
            qw.eq("phone", username);
        }
        User user = super.getOne(qw);
        return user;
    }

    @PostMapping("/user/save")
    public Boolean userSave(@RequestBody User user) {
        int integer = userMapper.insert(user);
        if (integer > 0) {
            return true;
        }
        return false;
    }
    /*修改用户信息
     * */
    @PostMapping("/user/update")
    public Boolean userUpdate(@RequestBody User user) {
        int integer = userMapper.updateById(user);
        if (integer > 0) {
            return true;
        }
        return false;
    }
    /*
     * 分页获取用户信息*/

    @PostMapping("/user/pageList")
    public Map<String,Object> pageListUser(@RequestParam(value = "pageNo") int pageNo,
                                           @RequestParam(value = "pageNum") int pageNum){
        Page<User> page = new Page<User>(pageNo, pageNum);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        IPage<User> pageList =  page(page,queryWrapper);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("records",pageList.getRecords());
        map.put("pages",pageList.getPages());
        map.put("total",pageList.getTotal());
        return map;
    }
    @PostMapping("/auth/queryByUserId")
    public User queryByUserId(@RequestParam(value = "id") String id) {
        return super.getById(id);
    }
    @PostMapping("/user/deleteByUserId")
    public boolean deleteByUserId(@RequestParam(value = "id") String id) throws Exception {
        return super.removeById(id);
    }
    @PostMapping("/user/deleteByUserIds")
    public boolean deleteByUserIds(@RequestParam(value = "ids") String ids) throws Exception {
        String[] id = ids.split(",");
        List list = new ArrayList<String>();
        for (String userId : id
        ) {
            list.add(userId);
        }
        return super.removeByIds(list);
    }
}

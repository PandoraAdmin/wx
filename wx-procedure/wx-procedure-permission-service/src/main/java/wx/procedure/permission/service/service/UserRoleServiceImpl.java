package wx.procedure.permission.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wx.procedure.permission.service.entity.UserRole;
import wx.procedure.permission.service.mapper.UserRoleMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> {
    @PostMapping("/userRole/save")
    public Boolean userRoleSave(@RequestBody UserRole userRole) {
        return super.save(userRole);
    }
    /*修改用户信息
     * */
    @PostMapping("/userRole/update")
    public Boolean userRoleUpdate(@RequestBody UserRole userRole) {
        return super.updateById(userRole);
    }
    /*
     * 分页获取用户信息*/
    @PostMapping("/userRole/pageList")
    public Map<String, Object> pageList(@RequestParam(value = "pageNo") int pageNo,
                                            @RequestParam(value = "pageNum") int pageNum) {
        Page<UserRole> page = new Page<UserRole>(pageNo, pageNum);
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<UserRole>();
        IPage<UserRole> pageList = page(page, queryWrapper);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("records", pageList.getRecords());
        map.put("pages", pageList.getPages());
        map.put("total", pageList.getTotal());
        return map;
    }

    @PostMapping("/auth/queryByUserRoleId")
    public UserRole queryByUserRoleId(@RequestParam(value = "id") String id) {
        return super.getById(id);
    }

    @PostMapping("/userRole/deleteByUserRoleId")
    public boolean deleteByUserRoleId(@RequestParam(value = "id") String id) throws Exception {
        return super.removeById(id);
    }

    @PostMapping("/userRole/deleteByUserRoleIds")
    public boolean deleteByUserRoleIds(@RequestParam(value = "ids") String ids) throws Exception {
        String[] id = ids.split(",");
        List list = new ArrayList<String>();
        for (String userId : id
        ) {
            list.add(userId);
        }
        return super.removeByIds(list);
    }
}

package wx.procedure.permission.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wx.procedure.permission.service.entity.Role;
import wx.procedure.permission.service.mapper.RoleMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> {

    @PostMapping("/role/save")
    public Boolean roleSave(@RequestBody Role role) {
        return super.save(role);
    }
    /*修改用户信息
     * */
    @PostMapping("/role/update")
    public Boolean roleUpdate(@RequestBody Role role) {
        return super.updateById(role);
    }
    /*
     * 分页获取用户信息*/
    @PostMapping("/role/pageList")
    public Map<String, Object> pageList(@RequestParam(value = "pageNo") int pageNo,
                                            @RequestParam(value = "pageNum") int pageNum) {
        Page<Role> page = new Page<Role>(pageNo, pageNum);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>();
        IPage<Role> pageList = page(page, queryWrapper);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("records", pageList.getRecords());
        map.put("pages", pageList.getPages());
        map.put("total", pageList.getTotal());
        return map;
    }

    @PostMapping("/auth/queryByRoleId")
    public Role queryByRoleId(@RequestParam(value = "id") String id) {
        return super.getById(id);
    }

    @PostMapping("/role/deleteByRoleId")
    public boolean deleteByRoleId(@RequestParam(value = "id") String id) throws Exception {
        return super.removeById(id);
    }

    @PostMapping("/role/deleteByRoleIds")
    public boolean deleteByRoleIds(@RequestParam(value = "ids") String ids) throws Exception {
        String[] id = ids.split(",");
        List list = new ArrayList<String>();
        for (String userId : id
        ) {
            list.add(userId);
        }
        return super.removeByIds(list);
    }
}

package wx.procedure.permission.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wx.procedure.permission.service.entity.RolePower;
import wx.procedure.permission.service.mapper.RolePowerMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public class RolePowerServiceImpl extends ServiceImpl<RolePowerMapper, RolePower> {
    @PostMapping("/rolePower/save")
    public Boolean rolePowerSave(@RequestBody RolePower rolePower) {
        return super.save(rolePower);
    }
    /*修改用户信息
     * */
    @PostMapping("/rolePower/update")
    public Boolean rolePowerUpdate(@RequestBody RolePower rolePower) {
        return super.updateById(rolePower);
    }
    /*
     * 分页获取用户信息*/
    @PostMapping("/rolePower/pageList")
    public Map<String, Object> pageList(@RequestParam(value = "pageNo") int pageNo,
                                            @RequestParam(value = "pageNum") int pageNum) {
        Page<RolePower> page = new Page<RolePower>(pageNo, pageNum);
        QueryWrapper<RolePower> queryWrapper = new QueryWrapper<RolePower>();
        IPage<RolePower> pageList = page(page, queryWrapper);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("records", pageList.getRecords());
        map.put("pages", pageList.getPages());
        map.put("total", pageList.getTotal());
        return map;
    }

    @PostMapping("/auth/queryByRolePowerId")
    public RolePower queryByRolePowerId(@RequestParam(value = "id") String id) {
        return super.getById(id);
    }

    @PostMapping("/rolePower/deleteByRolePowerId")
    public boolean deleteByRolePowerId(@RequestParam(value = "id") String id) throws Exception {
        return super.removeById(id);
    }

    @PostMapping("/rolePower/deleteByRolePowerIds")
    public boolean deleteByRolePowerIds(@RequestParam(value = "ids") String ids) throws Exception {
        String[] id = ids.split(",");
        List list = new ArrayList<String>();
        for (String userId : id
        ) {
            list.add(userId);
        }
        return super.removeByIds(list);
    }
}

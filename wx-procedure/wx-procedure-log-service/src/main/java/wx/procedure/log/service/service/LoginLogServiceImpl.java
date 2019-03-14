package wx.procedure.log.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wx.procedure.log.service.entity.LoginLog;
import wx.procedure.log.service.mapper.LoginLogMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> {
    @Qualifier
    LoginLogMapper loginLogMapper;

    @PostMapping("/loginLog/save")
    public Boolean loginLogSave(@RequestBody LoginLog loginLog) {
        return super.save(loginLog);
    }
    /*修改用户信息
     * */
    @PostMapping("/loginLog/update")
    public Boolean loginLogUpdate(@RequestBody LoginLog loginLog) {
        return super.updateById(loginLog);
    }
    /*
     * 分页获取用户信息*/
    @PostMapping("/loginLog/pageList")
    public Map<String, Object> pageList(@RequestParam(value = "pageNo") int pageNo,
                                            @RequestParam(value = "pageNum") int pageNum) {
        Page<LoginLog> page = new Page<LoginLog>(pageNo, pageNum);
        QueryWrapper<LoginLog> queryWrapper = new QueryWrapper<LoginLog>();
        IPage<LoginLog> pageList = page(page, queryWrapper);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("records", pageList.getRecords());
        map.put("pages", pageList.getPages());
        map.put("total", pageList.getTotal());
        return map;
    }

    @PostMapping("/auth/queryByLoginLogId")
    public LoginLog queryByLoginLogId(@RequestParam(value = "id") String id) {
        return super.getById(id);
    }

    @PostMapping("/loginLog/deleteByLoginLogId")
    public boolean deleteByLoginLogId(@RequestParam(value = "id") String id) throws Exception {
        return super.removeById(id);
    }

    @PostMapping("/loginLog/deleteByLoginLogIds")
    public boolean deleteByLoginLogIds(@RequestParam(value = "ids") String ids) throws Exception {
        String[] id = ids.split(",");
        List list = new ArrayList<String>();
        for (String userId : id
        ) {
            list.add(userId);
        }
        return super.removeByIds(list);
    }
}
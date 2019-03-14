package wx.procedure.log.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wx.procedure.log.service.entity.ErrorLog;
import wx.procedure.log.service.mapper.ErrorLogMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ErrorLogMapperServiceImpl extends ServiceImpl<ErrorLogMapper, ErrorLog> {
    @Autowired
    ErrorLogMapper errorLogMapper;

    @PostMapping("/errorLog/save")
    public Boolean errorLogSave(@RequestBody ErrorLog errorLog) {
        return super.save(errorLog);
    }
    /*修改用户信息
     * */
    @PostMapping("/errorLog/update")
    public Boolean errorLogUpdate(@RequestBody ErrorLog errorLog) {
        return super.updateById(errorLog);
    }
    /*
     * 分页获取用户信息*/
    @PostMapping("/errorLog/pageList")
    public Map<String, Object> pageList(@RequestParam(value = "pageNo") int pageNo,
                                            @RequestParam(value = "pageNum") int pageNum) {
        Page<ErrorLog> page = new Page<ErrorLog>(pageNo, pageNum);
        QueryWrapper<ErrorLog> queryWrapper = new QueryWrapper<ErrorLog>();
        IPage<ErrorLog> pageList = page(page, queryWrapper);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("records", pageList.getRecords());
        map.put("pages", pageList.getPages());
        map.put("total", pageList.getTotal());
        return map;
    }

    @PostMapping("/auth/queryByErrorLogId")
    public ErrorLog queryByErrorLogId(@RequestParam(value = "id") String id) {
        return super.getById(id);
    }

    @PostMapping("/errorLog/deleteByErrorLogId")
    public boolean deleteByErrorLogId(@RequestParam(value = "id") String id) throws Exception {
        return super.removeById(id);
    }

    @PostMapping("/errorLog/deleteByErrorLogIds")
    public boolean deleteByErrorLogIds(@RequestParam(value = "ids") String ids) throws Exception {
        String[] id = ids.split(",");
        List list = new ArrayList<String>();
        for (String userId : id
        ) {
            list.add(userId);
        }
        return super.removeByIds(list);
    }
}

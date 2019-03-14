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
import wx.procedure.log.service.entity.OperateLog;
import wx.procedure.log.service.mapper.OperateLogMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> {
    @Autowired
    OperateLogMapper operateLogMapper;
    @PostMapping("/operateLog/save")
    public Boolean operateLogSave(@RequestBody OperateLog operateLog) {
        return super.save(operateLog);
    }
    /*修改用户信息
     * */
    @PostMapping("/operateLog/update")
    public Boolean operateLogUpdate(@RequestBody OperateLog operateLog) {
        return super.updateById(operateLog);
    }
    /*
     * 分页获取用户信息*/
    @PostMapping("/operateLog/pageList")
    public Map<String, Object> pageList(@RequestParam(value = "pageNo") int pageNo,
                                            @RequestParam(value = "pageNum") int pageNum) {
        Page<OperateLog> page = new Page<OperateLog>(pageNo, pageNum);
        QueryWrapper<OperateLog> queryWrapper = new QueryWrapper<OperateLog>();
        IPage<OperateLog> pageList = page(page, queryWrapper);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("records", pageList.getRecords());
        map.put("pages", pageList.getPages());
        map.put("total", pageList.getTotal());
        return map;
    }

    @PostMapping("/auth/queryByOperateLogId")
    public OperateLog queryByOperateLogId(@RequestParam(value = "id") String id) {
        return super.getById(id);
    }

    @PostMapping("/operateLog/deleteByOperateLogId")
    public boolean deleteByOperateLogId(@RequestParam(value = "id") String id) throws Exception {
        return super.removeById(id);
    }

    @PostMapping("/operateLog/deleteByOperateLogIds")
    public boolean deleteByOperateLogIds(@RequestParam(value = "ids") String ids) throws Exception {
        String[] id = ids.split(",");
        List list = new ArrayList<String>();
        for (String userId : id
        ) {
            list.add(userId);
        }
        return super.removeByIds(list);
    }
}

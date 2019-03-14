package wx.procedure.log.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wx.procedure.log.service.entity.ErrorLog;

@Mapper
public interface ErrorLogMapper extends BaseMapper<ErrorLog> {
}

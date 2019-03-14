package wx.procedure.user.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wx.procedure.user.service.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}


package wx.procedure.permission.service.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @数表名称  t_sys_user_role
 * @开发日期  2018-06-27 09:52:15
 * @开发作者  rookie 
 */
@Data
@TableName("t_sys_user_role")
public class UserRole implements Serializable {
    /**
     * 编号 (主健ID) (无默认值)
     */
    @TableId
    private String id;

    /**
     * 用户编号(必填项) (无默认值)
     */
    @TableField( "user_id")
    private String userId;

    /**
     * 角色编号(必填项) (无默认值)
     */
    private String roleId;

    private static final long serialVersionUID = 1L;
}
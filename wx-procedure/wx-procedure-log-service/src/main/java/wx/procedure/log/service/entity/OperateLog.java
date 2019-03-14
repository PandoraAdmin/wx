package wx.procedure.log.service.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @数表名称  t_sys_operate_log
 * @开发日期  2018-06-27 09:52:15
 * @开发作者  rookie 
 */
@Data
@TableName("t_sys_operate_log")
public class OperateLog implements Serializable {
    /**
     * 编号 (主健ID) (无默认值)
     */
    @TableId
    private String id;

    /**
     * 用户编号(必填项) (无默认值)
     */
    @TableField("user_id")
    private String userId;

    /**
     * 访问地址(必填项) (无默认值)
     */
    private String url;

    /**
     * 请求参数(必填项) (无默认值)
     */
    private String params;

    /**
     * 创建时间(必填项)  (默认值为: CURRENT_TIMESTAMP)
     */
    private Date createTime;

    private String extendsOne;

    private String extendsTwo;

    private String extendsThree;

    private static final long serialVersionUID = 1L;
}
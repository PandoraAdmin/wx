package wx.procedure.log.service.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @数表名称  t_sys_login_log
 * @开发日期  2018-06-27 09:52:15
 * @开发作者  rookie 
 */
@Data
@TableName("t_sys_login_log")
public class LoginLog implements Serializable {
    /**
     * 编号 (主健ID) (无默认值)
     */
    @TableId
    private String id;

    /**
     * IP地址(必填项) (无默认值)
     */
    private String ip;

    /**
     * 登录账户(必填项) (无默认值)
     */
    private String account;

    /**
     * 内容(可选项) (无默认值)
     */
    private String content;

    /**
     * 登录结果(必填项) (无默认值)
     */
    private Integer result;

    /**
     * 创建时间(必填项)  (默认值为: CURRENT_TIMESTAMP)
     */
    private Date createTime;

    private String extendsOne;

    private String extendsTwo;

    private String extendsThree;

    private static final long serialVersionUID = 1L;
}
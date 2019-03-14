package wx.procedure.caller.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Pandora
 */
@Data
public class User implements Serializable {
    /**
     * 编号 (主健ID) (无默认值)
     */
    private String id;
    /**
     * 单位编号(必填项) (无默认值)
     */
    private String orgId;

    /**
     * 用户真实姓名(必填项) (无默认值)
     */
    private String name;

    /**
     * 登录账号(必填项) (无默认值)
     */
    private String account;

    /**
     * 登录密码(必填项) (无默认值)
     */
    private String password;

    /**
     * 用户性别(必填项)  (默认值为: 0)
     */
    private Byte sex;

    /**
     * 联系电话(必填项) (无默认值)
     */
    private String phone;

    /**
     * 用户类型(必填项) (无默认值)
     */
    private String type;

    /**
     * 状态(必填项) (无默认值)
     */
    private String status;

    /**
     * 创建时间(必填项)  (默认值为: CURRENT_TIMESTAMP)
     */
    private Date createTime;

    private String extendsOne;

    private String extendsTwo;

    private String extendsThree;

    private static final long serialVersionUID = 1L;
}
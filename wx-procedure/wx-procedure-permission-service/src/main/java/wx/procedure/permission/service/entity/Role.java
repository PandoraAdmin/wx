package wx.procedure.permission.service.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @数表名称  t_sys_role
 * @开发日期  2018-06-27 09:52:15
 * @开发作者  rookie 
 */
@Data
@TableName( "t_sys_role")
public class Role implements Serializable {
    /**
     * 编号 (主健ID) (无默认值)
     */
    @TableId
    private String id;

    /**
     * 角色名称(必填项) (无默认值)
     */
    private String name;

    /**
     * 排序号(必填项)  (默认值为: 0)
     */
    private Integer seq;

    /**
     * 角色简介(可选项) (无默认值)
     */
    private String description;

    /**
     * 状态(必填项)  (默认值为: 1)
     */
    private String status;

    /**
     * 创建时间(必填项)  (默认值为: CURRENT_TIMESTAMP)
     */
    @TableField("create_time")
    private Date createTime;

    private String extendsOne;

    private String extendsTwo;

    private String extendsThree;

    private static final long serialVersionUID = 1L;
}
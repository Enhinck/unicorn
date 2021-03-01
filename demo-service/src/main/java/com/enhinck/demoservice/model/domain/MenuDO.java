package com.enhinck.demoservice.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 菜单
 *
 * @author huenb
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
public class MenuDO extends Model<MenuDO> {

    private static final long serialVersionUID = -1006367285600013222L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 平台编码
     **/
    private String platformCode;
    /**
     * 逻辑删除标志
     */
    @TableLogic(value = "0", delval = "1")
    private String status;

    /**
     * 创建日期
     */
    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private Date gmtCreate;
    /**
     * 更新日期
     */
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private Date gmtModify;
    /**
     * 菜单名称
     **/
    private String name;
    /**
     * 菜单权限id
     **/
    private Long permissionId;

    /**
     * 权限编码
     **/
    @TableField(exist = false)
    private String permissionCode;
    /**
     * 菜单编码
     **/
    private String menuCode;
    /**
     * 请求链接
     **/
    private String url;
    /**
     * 请求方法
     **/
    private String method;
    /**
     * 父菜单ID
     **/
    private Long parentId;
    /**
     * 图标
     **/
    private String icon;
    /**
     * VUE页面
     **/
    private String component;
    /**
     * 排序值
     **/
    private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     **/
    private String type;
    /**
     * 前端url
     **/
    private String path;
    /**
     *
     **/
    private Integer enable;
}

package com.enhinck.demoservice.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 数据字典
 *
 * @author huenb
 */
@Data
@TableName(value = "sys_dictionary")
public class DictionaryDO extends Model<DictionaryDO> {
    private static final long serialVersionUID = -1006367285600013222L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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
     * 数据值
     **/
    private String value;
    /**
     * 标签名
     **/
    private String label;
    /**
     * 类型
     **/
    private String type;
    /**
     * 描述
     **/
    private String description;
    /**
     * 排序
     **/
    private Integer sort;
    /**
     * 备注信息
     **/
    private String remark;
}

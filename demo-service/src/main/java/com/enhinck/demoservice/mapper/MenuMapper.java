package com.enhinck.demoservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enhinck.demoservice.model.domain.MenuDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends BaseMapper<MenuDO> {
    @Select("select * from sys_menu")
    List<MenuDO> selectAll();
}

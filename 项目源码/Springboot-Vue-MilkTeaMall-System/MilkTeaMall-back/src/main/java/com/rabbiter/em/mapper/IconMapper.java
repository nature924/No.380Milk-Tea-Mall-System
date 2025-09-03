package com.rabbiter.em.mapper;

import com.rabbiter.em.entity.Icon;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface IconMapper extends BaseMapper<Icon> {

    List<Icon> getIconCategoryMapList();
}

package com.rabbiter.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value="icon_category")
public class IconCategory {
    private Long iconId;

    private Long categoryId;

    public Long getIconId() {
        return iconId;
    }

    public void setIconId(Long iconId) {
        this.iconId = iconId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

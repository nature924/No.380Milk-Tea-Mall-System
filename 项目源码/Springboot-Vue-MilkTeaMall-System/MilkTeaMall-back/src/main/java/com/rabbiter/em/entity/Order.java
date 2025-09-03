package com.rabbiter.em.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;

@TableName("t_order")
public class Order extends Model<Order> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 订单编号 
      */
    private String orderNo;

    /**
      * 总价 
      */
    private BigDecimal totalPrice;

    /**
      * 下单人id 
      */
    private int userId;

    /**
      * 联系人 
      */
    private String linkUser;

    /**
      * 联系电话 
      */
    private String linkPhone;

    /**
      * 送货地址 
      */
    private String linkAddress;

    /**
      * 状态 
      */
    private String state;

    /**
      * 创建时间 
      */
    private String createTime;

    //该订单包含的商品信息
    @TableField(exist = false)
    private String goods;

    // 对应购物车id
    @TableField(exist = false)
    private Long cartId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLinkUser() {
        return linkUser;
    }

    public void setLinkUser(String linkUser) {
        this.linkUser = linkUser;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", totalPrice=" + totalPrice +
                ", userId=" + userId +
                ", linkUser='" + linkUser + '\'' +
                ", linkPhone='" + linkPhone + '\'' +
                ", linkAddress='" + linkAddress + '\'' +
                ", state='" + state + '\'' +
                ", createTime='" + createTime + '\'' +
                ", goods='" + goods + '\'' +
                ", cartId=" + cartId +
                '}';
    }
}
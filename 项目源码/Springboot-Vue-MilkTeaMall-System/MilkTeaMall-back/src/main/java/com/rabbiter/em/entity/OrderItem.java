package com.rabbiter.em.entity;

/*
用来接收前台下订单时，传来的‘goods'参数
 */
public class OrderItem {

    /*
    商品id
     */
    private long id;
    /*
    商品规格
     */
    private String standard;
    /*
    数量
     */
    private int num;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", standard='" + standard + '\'' +
                ", num=" + num +
                '}';
    }
}

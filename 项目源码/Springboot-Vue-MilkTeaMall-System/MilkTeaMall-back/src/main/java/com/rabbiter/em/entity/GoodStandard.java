package com.rabbiter.em.entity;


/*
商品规格及对应库存
 */
public class GoodStandard {
    private int goodId;
    private String value;
    private double price;
    private int store;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "GoodStandard{" +
                "goodId=" + goodId +
                ", value='" + value + '\'' +
                ", price=" + price +
                ", store=" + store +
                '}';
    }
}

package com.fb.zhuangshiqi;

public class FiredRiceWithEgg extends Food{

    private int price = 10;

    private String name = "鸡蛋炒饭";

    public FiredRiceWithEgg() {
    }

    public FiredRiceWithEgg(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getTotalPrice() {
        return getPrice();
    }

    @Override
    public String getFoodName() {
        return name;
    }
}

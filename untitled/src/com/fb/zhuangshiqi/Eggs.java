package com.fb.zhuangshiqi;

public class Eggs extends PeiLiao{

    private int price = 5;

    private String name = "鸡蛋";

    public Eggs(Food food) {
        super(food);
    }

    @Override
    public int getTotalPrice() {
        return food.getTotalPrice() + this.price;
    }

    @Override
    public String getFoodName() {
        return name + food.getFoodName();
    }

    public int getPrice() {
        return price;
    }


}

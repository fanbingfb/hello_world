package com.fb.zhuangshiqi;

public class test {
    public static void main(String[] args) {
        FiredRiceWithEgg firedRiceWithEgg = new FiredRiceWithEgg();
        PeiLiao peiLiao1 = new Eggs(firedRiceWithEgg);
        PeiLiao peiLiao2 = new Eggs(peiLiao1);
        PeiLiao peiLiao3 = new Eggs(peiLiao2);
        System.out.println(firedRiceWithEgg.getTotalPrice());
        System.out.println(peiLiao1.getTotalPrice());
        System.out.println(peiLiao1.getFoodName());
        System.out.println(peiLiao2.getTotalPrice());
        System.out.println(peiLiao2.getFoodName());
        System.out.println(peiLiao3.getTotalPrice());
        System.out.println(peiLiao3.getFoodName());
        int j = 1;
        int i = 1;
    }
}

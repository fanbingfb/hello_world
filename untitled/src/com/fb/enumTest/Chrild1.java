package com.fb.enumTest;

import java.util.List;

public class Chrild1 extends Parent{
    public List addList() {
        List<Integer> list = getList();
        list.add(2);
        for (Integer i : list) {
            System.out.println(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Chrild1 chrild1 = new Chrild1();
        Chrild2 chrild2 = new Chrild2();
        boolean b = chrild1.addList() == chrild2.addList();
        System.out.println(b);
    }
}

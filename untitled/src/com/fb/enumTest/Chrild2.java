package com.fb.enumTest;

import java.util.List;

public class Chrild2 extends Parent{
    public List addList() {
        List<Integer> list = getList();
        System.out.println(list);
        list.add(1);
        for (Integer i : list) {
            System.out.println(i);
        }
        return list;
    }
}

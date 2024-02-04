package com.fb.enumTest;

import java.util.ArrayList;
import java.util.List;

public class Parent {
    private List<Integer> list = new ArrayList<>();

    public Parent() {
        System.out.println("构造函数执行了");
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }
}

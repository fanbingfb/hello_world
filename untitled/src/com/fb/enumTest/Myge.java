package com.fb.enumTest;


import java.util.List;

public class  Myge<T extends Comparable> {
    private T name;

    public void setList (List<? extends MyEnum> list) {
        list.add()
    }

    public Integer compareToOther(T other) {
        return name.compareTo(other);
    }

    public static void main(String[] args) {
    }
}


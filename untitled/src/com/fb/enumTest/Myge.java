package com.fb.enumTest;


import com.fb.Employee;
import com.fb.Manager;

import java.util.ArrayList;
import java.util.List;

public class  Myge<T extends Manager> {
    private T name;

    private List<? super Employee> list = new ArrayList<>();
    public void setList (T one) {
        list.add(one);
    }

//    public Integer compareToOther(T other) {
//        return name.compareTo(other);
//    }

    public static void main(String[] args) {
        Myge<Manager> employeeMyge = new Myge<>();
        employeeMyge.setList(new Manager());
    }
}


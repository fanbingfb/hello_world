package com.fb.likou;

import java.util.HashMap;

public class Main<K,V> {

    private HashMap<K,V> map;

    public <T> T getO(T t) {
        return t;
    }


    public static void main(String[] args) {
        Main<String,String> main = new Main();
        main.map.put("1","2");
    }


}

package com.fb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Test {
    public static final Logger LOGGER = Logger.getLogger("com.mylog");
    public static void main(String[] args) throws IOException {
        Animal animal = (Animal) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{Animal.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName());
                        if (args != null) {
                            Stream<Object> stream = Arrays.stream(args);
                            stream.forEach(System.out::println);
                        }
                        return method.invoke(new dog(),args);
                    }
                });
        animal.drink(18);
        System.out.println("这是一个分界线");
        animal.eat("站着");
        System.in.read();
    }
}
interface Animal{
    default void eat(String activity){
        System.out.println(1);
    };
    void drink(Integer age);
}

class dog implements Animal {

    @Override
    public void eat(String activity) {
        System.out.println("狗狗正在吃东西" + "正在做" + activity + "动作");
    }

    @Override
    public void drink(Integer age) {
        System.out.println("狗狗正在喝水:" + "年龄为" + age + "岁");
    }
}

//class cat implements Animal {
//
//    @Override
//    public void eat() {
//        System.out.println("猫正在吃东西");
//    }
//
//    @Override
//    public void drink() {
//        System.out.println("猫正在喝水");
//    }
//}

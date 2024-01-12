package com.fb.enumTest;

public enum MyEnum {
    fb("范冰",18),
    lhz("李鸿章",58),
    ;
    private String name;
    private Integer age;

    MyEnum(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        String fbString = MyEnum.fb.toString();
        System.out.println(fbString);
    }
}

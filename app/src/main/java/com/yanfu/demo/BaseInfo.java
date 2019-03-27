package com.yanfu.demo;

import java.io.Serializable;

/**
 * Created by yanfu on 2019/3/27.
 */

public class BaseInfo implements Serializable {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public BaseInfo(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

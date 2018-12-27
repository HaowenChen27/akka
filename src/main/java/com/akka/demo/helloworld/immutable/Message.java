package com.akka.demo.helloworld.immutable;

import java.util.Collections;
import java.util.List;

/**
 * actor传递的消息要是不可变的，为了安全
 */
public final class Message {

    private final int age;

    private final List<String> list;

    public Message(int age,List<String> list){
        this.age = age;
        //将list包装成不可变对象
        this.list = Collections.unmodifiableList(list);
    }

    public int getAge() {
        return age;
    }

    public List<String> getList() {
        return list;
    }
}

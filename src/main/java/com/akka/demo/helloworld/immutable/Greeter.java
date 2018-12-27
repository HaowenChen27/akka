package com.akka.demo.helloworld.immutable;

import akka.actor.UntypedAbstractActor;
import com.alibaba.fastjson.JSONObject;

public class Greeter extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        try{
            System.out.println("Geeter收到的数据是："+JSONObject.toJSON(message));
            getSender().tell("Greeter工作完成",getSelf());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.akka.demo.helloworld.immutable;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

import java.util.Arrays;

public class HelloWorld extends UntypedAbstractActor {

    @Override
    public void preStart() throws Exception {
        ActorRef greeterActor = getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("Greeter ：" + greeterActor.path());
        greeterActor.tell(new Message(2,Arrays.asList("faker","bang")),getSelf());
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        try{
            System.out.println("HelloWorld收到的消息是:"+message.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

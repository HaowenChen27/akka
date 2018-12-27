package com.akka.demo.helloworld.lifecycle;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;

public class MainLifeCycle {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("Hello");
        ActorRef myWork = system.actorOf(Props.create(MyWork.class),"myWork");
        ActorRef watchActor = system.actorOf(Props.create(WatchActor.class,myWork),"Watch");
        myWork.tell(MyWork.Msg.Working,ActorRef.noSender());
        myWork.tell(MyWork.Msg.done,ActorRef.noSender());

        //中断myWork
        myWork.tell(PoisonPill.getInstance(),ActorRef.noSender());
    }
}

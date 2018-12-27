package com.akka.demo.helloworld.lifecycle;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class VisorMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("strategy");
        ActorRef superVisor = system.actorOf(Props.create(SuperVisor.class),"SuperVisor");
        superVisor.tell(Props.create(RestartActor.class),ActorRef.noSender());
        ActorSelection actorSelection = system.actorSelection("akka://strategy/user/SuperVisor/restartActor");//这是akka的路径。restartActor是在SuperVisor中创建的。

        for(int i = 0 ; i < 100 ; i ++){
            actorSelection.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
        }
    }
}

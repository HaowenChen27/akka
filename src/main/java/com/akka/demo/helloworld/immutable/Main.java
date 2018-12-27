package com.akka.demo.helloworld.immutable;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("Hello");
        ActorRef helloActor = system.actorOf(Props.create(HelloWorld.class),"HelloWorld");
        System.out.println(helloActor.path());
        helloActor.tell("Starting",null);
    }
}

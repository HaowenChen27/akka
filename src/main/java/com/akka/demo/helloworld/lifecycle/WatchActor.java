package com.akka.demo.helloworld.lifecycle;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class WatchActor extends UntypedAbstractActor {

    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    public WatchActor(ActorRef actor){

        getContext().watch(actor);

    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof Terminated){
            logger.error(((Terminated)message).getActor().path()+"has Terminated. now shutdown the system");
            getContext().system().terminate();
        }else{
            unhandled(message);
        }
    }
}

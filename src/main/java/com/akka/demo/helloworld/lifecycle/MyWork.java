package com.akka.demo.helloworld.lifecycle;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyWork extends UntypedAbstractActor {

    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    public enum Msg{
        Working,done,Closed;
    }

    @Override
    public void preStart() throws Exception {
        logger.info("myWork starting.");
    }

    @Override
    public void postStop() throws Exception {
        logger.info("myWork stopping.");
    }

    @Override
    public void onReceive(Object message) throws Throwable {

        try{
            if(message == Msg.Working){
                logger.info("I am Working.");
            }else if(message ==Msg.done){
                logger.info("stop working.");
            }else if(message == Msg.Closed){
                logger.info("stop closed");
                getSender().tell(Msg.Closed,getSelf());
            }else{
                unhandled(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

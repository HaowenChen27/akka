package com.akka.demo.helloworld.lifecycle;

import akka.actor.UntypedAbstractActor;
import scala.Option;

import java.util.Optional;

public class RestartActor extends UntypedAbstractActor {

    public  enum  Msg{
        DONE, RESTART;
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("preStart    hashCode=" + this.hashCode());
    }
    @Override
    public void postStop() throws Exception {
        System.out.println("postStop    hashCode=" + this.hashCode());
    }


    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        super.preRestart(reason, message);
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
        System.out.println("postRestart    hashCode=" + this.hashCode());
    }



    @Override
    public void onReceive(Object o) throws Throwable {
        if(o == Msg.DONE){
            getContext().stop(getSelf());
        }else if(o == Msg.RESTART){
            System.out.println(((Object) null).toString());
            //抛出异常，默认会被restart，但这里会resume
            //double a = 1/0;
        }else{
            unhandled(o);
        }

    }
}

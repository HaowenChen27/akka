package com.akka.demo;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class CreationActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Op.MathOp){
            ActorRef calculator = getContext().actorOf(Props.create(CalculatorActor.class));
            calculator.tell(message,getSelf());
        }else if(message instanceof Op.MultiplyResult){
            Op.MultiplyResult result = (Op.MultiplyResult) message;
            System.out.printf("Mul result: %d * %d = %d ",result.getN1(),result.getN2(),result.getResult());
            getContext().stop(getSender());
        }else if(message instanceof Op.DivideResult){
            Op.DivideResult result = (Op.DivideResult) message;
            System.out.printf("Div result: %.0f / %d = %.2f ",result.getN1(),result.getN2(),result.getResult());
            getContext().stop(getSender());
        }else{
            unhandled(message);
        }
    }
}

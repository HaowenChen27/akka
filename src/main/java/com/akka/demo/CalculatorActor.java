package com.akka.demo;

import akka.actor.UntypedAbstractActor;

public class CalculatorActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof Op.Add){
            Op.Add add = (Op.Add) message;
            System.out.println("Calculating " + add.getN1() +"+"+ add.getN2());
            Op.AddResult addResult = new Op.AddResult(add.getN1(),add.getN2(),add.getN1()+add.getN2());
            getSender().tell(addResult,getSelf());
        }else if(message instanceof Op.Subtract){
            Op.Subtract subtract = (Op.Subtract) message;
            System.out.println("Calculating " + subtract.getN1() + "-" +subtract.getN2());
            Op.SubtractResult subtractResult = new Op.SubtractResult(subtract.getN1(),subtract.getN2(),subtract.getN1()-subtract.getN2());
            getSender().tell(subtractResult,getSelf());
        }else if (message instanceof  Op.Divide){
            Op.Divide divide = (Op.Divide) message;
            System.out.println("Calculating " + divide.getN1() + "÷" +divide.getN2());
            Op.DivideResult divideResult = new Op.DivideResult(divide.getN1(),divide.getN2(),divide.getN1()/divide.getN2());
            getSender().tell(divideResult,getSelf());
        }else if(message instanceof Op.Multiply){
            Op.Multiply multiply = (Op.Multiply) message;
            System.out.println("Calculating "+ multiply.getN1() + "*" + multiply.getN2());
            Op.MultiplyResult multiplyResult = new Op.MultiplyResult(multiply.getN1(),multiply.getN2(),multiply.getN1()*multiply.getN2());
            getSender().tell(multiplyResult,getSelf());
        }else{
            unhandled(message);
        }


    }
}

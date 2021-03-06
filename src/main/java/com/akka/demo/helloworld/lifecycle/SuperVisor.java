package com.akka.demo.helloworld.lifecycle;

import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedAbstractActor;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 监督者
 * 监督策略
 */
public class SuperVisor extends UntypedAbstractActor {

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return new OneForOneStrategy(3,Duration.ofSeconds(60),
                v -> {
                    if(v instanceof ArithmeticException){//ArithmeticException是出现异常的运算条件时，抛出此异常。例如，一个整数“除以零”时，抛出此类的一个实例。
                        System.out.println("meet ArithmeticException ,just resume.");
                        return  SupervisorStrategy.resume();//继续; 重新开始; 恢复职位;
                    }else if(v instanceof NullPointerException){
                        System.out.println("meet NullPointerException , restart.");
                        return SupervisorStrategy.restart();
                    }else if(v instanceof IllegalArgumentException){
                        System.out.println("meet IllegalArgumentException ,stop.");
                        return SupervisorStrategy.stop();
                    }else{
                        System.out.println("escalate.");
                        return SupervisorStrategy.escalate();//使逐步升级; 使逐步上升; 乘自动梯上升;也就是交给更上层的actor处理。抛出异常
                    }
                });
    }

    @Override
    public void onReceive(Object o) throws Throwable {
        if(o instanceof Props){
            getContext().actorOf((Props)o , "restartActor");
        }else{
            unhandled(o);
        }
    }
}

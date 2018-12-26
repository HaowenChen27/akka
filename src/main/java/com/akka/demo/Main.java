package com.akka.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(100);
        System.out.println(bigDecimal.setScale(2,RoundingMode.HALF_UP));
    }
}

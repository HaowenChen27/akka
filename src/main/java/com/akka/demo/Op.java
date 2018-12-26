package com.akka.demo;

import java.io.Serializable;

/**
 * 操作类，包括加减乘除操作类和结果类
 */
public class Op {

    public interface MathOp extends Serializable{}

    public interface MathResult extends Serializable{}

    //加法操作
    static class Add implements MathOp{

        private static final long serialVersionUID = 1536159329883134002L;
        private final int n1;
        private final int n2;

        public Add(int n1,int n2){
            this.n1 = n1;
            this.n2 = n2;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }
    }

    static class AddResult implements MathResult{

        private static final long serialVersionUID = -455690576986411681L;
        private final int n1;
        private final int n2;
        private final int result;
        public AddResult(int n1,int n2,int result){
            this.n1=n1;
            this.n2=n2;
            this.result=result;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }

        public int getResult() {
            return result;
        }
    }

    //减法操作
    static class Subtract implements MathOp{

        private static final long serialVersionUID = 2818857993465555119L;
        private final int n1;
        private final int n2;
        public Subtract(int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }
    }

    static class SubtractResult implements MathResult{

        private static final long serialVersionUID = 6256951765368568976L;
        private final int n1;
        private final int n2;
        private final int result;
        public SubtractResult(int n1,int n2,int result){
            this.n1=n2;
            this.n2=n2;
            this.result=result;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }

        public int getResult() {
            return result;
        }
    }

    //乘法操作
    static class Multiply implements MathOp{

        private static final long serialVersionUID = 7727609683964470712L;
        private final int n1;
        private final int n2;
        public Multiply(int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }
    }

    static class MultiplyResult implements MathResult{
        private static final long serialVersionUID = -3903396283882963202L;
        private final int n1;
        private final int n2;
        private final int result;

        public MultiplyResult(int n1,int n2,int result){
            this.n1 = n1;
            this.n2 = n2;
            this.result = result;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }

        public int getResult() {
            return result;
        }
    }

    //除法操作
    static class Divide implements MathOp{

        private static final long serialVersionUID = 7425982293118535589L;
        private final double n1;
        private final int n2;
        public Divide(double n1,int n2){
            this.n1 = n1;
            this.n2 = n2;
        }

        public double getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }
    }

    static class DivideResult implements MathResult{

        private static final long serialVersionUID = 75109963694994103L;
        private final double n1;
        private final int n2;
        private final double result;
        public DivideResult(double n1,int n2,double result){
            this.n1 = n1;
            this.n2 = n2;
            this.result = result;
        }

        public double getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }

        public double getResult() {
            return result;
        }
    }
}

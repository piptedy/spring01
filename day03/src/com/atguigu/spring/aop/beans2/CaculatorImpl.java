package com.atguigu.spring.aop.beans2;

//@Component("caculator")
public class CaculatorImpl implements Caculator {

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}

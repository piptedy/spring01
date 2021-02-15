package com.atguigu.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
//@Aspect
public class LogginAspect {

//    @Before(value = "execution(* com.atguigu.spring.aop.beans.Caculator.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method "+ methodName +" has args:"+ Arrays.toString(args));
    }
//    @After(value = "execution(* com.atguigu.spring.aop.beans.Caculator.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" ends");
    }
//    @AfterReturning(value = "execution(* com.atguigu.spring.aop.beans.Caculator.*(..))",returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" returns "+ result);
    }

//    @AfterThrowing(value = "execution(* com.atguigu.spring.aop.beans.Caculator.*(..))",throwing = "e")
    public void throwingAdivce(JoinPoint joinPoint,Throwable e){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" throws "+ e);
    }

//    @Around(value = "execution(* com.atguigu.spring.aop.beans.Caculator.*(..))")
    public Object aroundAdivce(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();

        Object result = null;
        try {
            //前置通知
            System.out.println("The method "+ methodName +" has args:"+ Arrays.toString(args));
            //执行方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method "+ methodName +" returns "+ result);
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("The method "+ methodName +" throws "+ throwable);
            throwable.printStackTrace();
        }finally {
            //后置通知
            System.out.println("The method "+ methodName +" ends");
        }
        return result;

    }
}

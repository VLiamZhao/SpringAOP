package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAdvice {
    @Before("execution(* org.example.beans.TimeBook.doAudit(..))")
    public void logBefore (JoinPoint jp) {
        String name = (String) jp.getArgs()[0];
        System.out.println(name + " starting ...");
    }

    @After("execution(* org.example.beans.TimeBook.doBreak(..))")
    public void logAfter(JoinPoint jp) {
        String name = (String) jp.getArgs()[0];
        System.out.println(name + " ending ...");
    }

    @AfterThrowing(pointcut = "execution(* org.example.beans.TimeBook.doCheck(..))", throwing = "error")
    public void logThrow(JoinPoint jp, Throwable error) {
        String name = (String) jp.getArgs()[0];
        System.out.println(name + " has errors ...");
        System.out.println("Error: " + error);
    }

    public void delete() {
        System.out.println("deleting ...");
    }

    @Around("execution(* org.example.beans.TimeBook.doAudit(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        String name = (String) pjp.getArgs()[0];
        System.out.println(name + " around before ...");
        Object obj = pjp.proceed();
        System.out.println(name + " around after ...");
        return obj;
    }
}

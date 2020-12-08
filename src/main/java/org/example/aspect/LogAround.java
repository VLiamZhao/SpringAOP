package org.example.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String name = (String)methodInvocation.getArguments()[0];
        System.out.println(name + " before method ...");
        Object obj = methodInvocation.proceed();
        System.out.println(name + " after method ...");
        return null;
    }
}

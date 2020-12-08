package org.example;

import org.example.beans.TimeBookInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJTest {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext actx = new ClassPathXmlApplicationContext("aspectjconfig.xml");
        TimeBookInterface tb = (TimeBookInterface) actx.getBean("timeBook");
        System.out.println(tb.getClass().getName());
        tb.doAudit("Alice");
        tb.doBreak("Bob");
        try {
            tb.doCheck("Steve");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

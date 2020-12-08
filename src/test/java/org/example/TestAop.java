package org.example;

import org.example.beans.TimeBookInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext actx = new ClassPathXmlApplicationContext("aopconfig.xml")) {
            TimeBookInterface tb = (TimeBookInterface) actx.getBean("logProxy");
            tb.doAudit("Bob");
        } catch (Exception e) {

        }
    }
}

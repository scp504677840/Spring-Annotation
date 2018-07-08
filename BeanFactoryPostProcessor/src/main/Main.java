package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.close();
    }

    //count: 8
    //name: org.springframework.context.annotation.internalConfigurationAnnotationProcessor
    //name: org.springframework.context.annotation.internalAutowiredAnnotationProcessor
    //name: org.springframework.context.annotation.internalRequiredAnnotationProcessor
    //name: org.springframework.context.event.internalEventListenerProcessor
    //name: org.springframework.context.event.internalEventListenerFactory
    //name: appConfig
    //name: myBeanFactoryPostProcessor
    //name: accountInfo
    //call AccountInfo
}

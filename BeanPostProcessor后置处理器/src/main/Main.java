package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }

        //关闭SpringIOC容器
        applicationContext.close();

        //postProcessBeforeInitialization: org.springframework.context.event.internalEventListenerProcessor-org.springframework.context.event.EventListenerMethodProcessor@7188af83
        //postProcessAfterInitialization: org.springframework.context.event.internalEventListenerProcessor-org.springframework.context.event.EventListenerMethodProcessor@7188af83
        //postProcessBeforeInitialization: org.springframework.context.event.internalEventListenerFactory-org.springframework.context.event.DefaultEventListenerFactory@247310d0
        //postProcessAfterInitialization: org.springframework.context.event.internalEventListenerFactory-org.springframework.context.event.DefaultEventListenerFactory@247310d0
        //postProcessBeforeInitialization: appConfig-main.AppConfig$$EnhancerBySpringCGLIB$$9e19ee04@2b30a42c
        //postProcessAfterInitialization: appConfig-main.AppConfig$$EnhancerBySpringCGLIB$$9e19ee04@2b30a42c
        //call AccountInfo
        //postProcessBeforeInitialization: accountInfo-AccountInfo{id=null, gmtCreate=null, gmtModified=null, name='null', balance=null}
        //postProcessAfterInitialization: accountInfo-AccountInfo{id=null, gmtCreate=null, gmtModified=null, name='null', balance=null}
        //org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        //org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        //org.springframework.context.annotation.internalRequiredAnnotationProcessor
        //org.springframework.context.event.internalEventListenerProcessor
        //org.springframework.context.event.internalEventListenerFactory
        //appConfig
        //myBeanPostProcessor
        //accountInfo

    }
}

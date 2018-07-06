package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //查看所有已注册组件名称
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        //org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        //org.springframework.context.annotation.internalRequiredAnnotationProcessor
        //org.springframework.context.event.internalEventListenerProcessor
        //org.springframework.context.event.internalEventListenerFactory
        //springConfig
        //accountInfoController
        //accountInfoRepository
        //accountInfoService
        //accountInfo
    }
}

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

    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory count: 10
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: org.springframework.context.annotation.internalConfigurationAnnotationProcessor
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: org.springframework.context.annotation.internalAutowiredAnnotationProcessor
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: org.springframework.context.annotation.internalRequiredAnnotationProcessor
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: org.springframework.context.event.internalEventListenerProcessor
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: org.springframework.context.event.internalEventListenerFactory
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: appConfig
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: myBeanDefinitionRegistryPostProcessor
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: myBeanFactoryPostProcessor
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: accountInfo
    //MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: hi
    //MyBeanFactoryPostProcessor#postProcessBeanFactory count: 10
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: org.springframework.context.annotation.internalConfigurationAnnotationProcessor
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: org.springframework.context.annotation.internalAutowiredAnnotationProcessor
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: org.springframework.context.annotation.internalRequiredAnnotationProcessor
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: org.springframework.context.event.internalEventListenerProcessor
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: org.springframework.context.event.internalEventListenerFactory
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: appConfig
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: myBeanDefinitionRegistryPostProcessor
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: myBeanFactoryPostProcessor
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: accountInfo
    //MyBeanFactoryPostProcessor#postProcessBeanFactory name: hi
    //call AccountInfo
    //call AccountInfo
}

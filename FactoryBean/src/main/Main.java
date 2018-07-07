package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }
        //org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        //org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        //org.springframework.context.annotation.internalRequiredAnnotationProcessor
        //org.springframework.context.event.internalEventListenerProcessor
        //org.springframework.context.event.internalEventListenerFactory
        //appConfig
        //accountInfoFactoryBean

        Object afb1 = applicationContext.getBean("accountInfoFactoryBean");
        Object afb2 = applicationContext.getBean("accountInfoFactoryBean");
        System.out.println(afb1.getClass());//class main.entities.AccountInfo
        System.out.println(afb1 == afb2);//true

        //得到原生的AccountInfoFactoryBean，只需在BeanName前加上 '&' 符号，前提是Bean是一个FactoryBean
        Object accountInfoFactoryBean = applicationContext.getBean("&accountInfoFactoryBean");
        System.out.println(accountInfoFactoryBean.getClass());//class main.AccountInfoFactoryBean
    }
}

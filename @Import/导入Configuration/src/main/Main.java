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
        //main.entities.Red
        //main.entities.Blue
        //main.entities.Green
        //main.entities.Black
        //main.ColorsConfig
        //yellow
        //orange
        //purple
    }
}

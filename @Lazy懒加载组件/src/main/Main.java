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

        Object accountInfo = applicationContext.getBean("accountInfo");
        System.out.println(accountInfo);
    }
    //运行结果：
    //org.springframework.context.annotation.internalConfigurationAnnotationProcessor
    //org.springframework.context.annotation.internalAutowiredAnnotationProcessor
    //org.springframework.context.annotation.internalRequiredAnnotationProcessor
    //org.springframework.context.event.internalEventListenerProcessor
    //org.springframework.context.event.internalEventListenerFactory
    //springConfig
    //accountInfoRepository
    //accountInfo
    //我被创建。
    //AccountInfo{id=3, gmtCreate=2018-07-07 01:22:20.522729, gmtModified=2018-07-07 01:22:20.523221, name='Tom', balance=5555}
}

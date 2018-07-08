package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }

        //获取AccountInfoService
        AccountInfoService accountInfoService = (AccountInfoService) applicationContext.getBean("accountInfoService");
        //调用AccountInfoService的say方法
        accountInfoService.say();

        //关闭SpringIOC容器
        applicationContext.close();

    }
}

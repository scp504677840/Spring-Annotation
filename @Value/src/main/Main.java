package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }

        AccountInfo accountInfo = (AccountInfo) applicationContext.getBean("accountInfo");
        System.out.println(accountInfo);
        //AccountInfo{id=18, gmtCreate=null, gmtModified=null, name='Tom', balance=1000}

        //关闭SpringIOC容器
        applicationContext.close();

    }
}

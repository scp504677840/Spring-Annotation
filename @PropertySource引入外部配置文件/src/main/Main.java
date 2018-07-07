package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }

        //获取Spring运行环境变量
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取property
        String property = environment.getProperty("accountInfo.balance");
        System.out.println(property);
        //1000

        //关闭SpringIOC容器
        applicationContext.close();

    }
}

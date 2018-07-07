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

        //在多实例时，只有在需要使用Bean的时候才会创建并初始化该Bean
        AccountInfo accountInfo = (AccountInfo) applicationContext.getBean("accountInfo");
        //手动销毁。多实例时，SpringIOC容器不会管理该Bean，也就无法调用到该Bean的销毁方法。
        accountInfo.destroy();
        accountInfo = null;

        //关闭SpringIOC容器
        applicationContext.close();

        //下面打印的是SpringIOC容器管理下的Bean的生命周期
        //call AccountInfo
        //call init
        //call destroy
    }
}

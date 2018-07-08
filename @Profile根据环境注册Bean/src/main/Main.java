package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * 注解@Profile：动态注册
     * 切换开发环境的两种方式：
     * 1.使用动态参数，在虚拟机参数位置加载：-Dspring.profiles.active=test
     * 2.使用AnnotationConfigApplicationContext无参构造函数，创建好实例之后
     * 使用applicationContext.getEnvironment().setActiveProfiles("test","dev","pro");设置激活多个开发环境。
     * 但是实际开发中，建议只启用一种开发环境。
     * 最后不要忘了注册配置类和刷新容器。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.创建无参的AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2.设置激活的环境，可以同时激活多个。
        //applicationContext.getEnvironment().setActiveProfiles("test","dev","pro");
        applicationContext.getEnvironment().setActiveProfiles("test");
        //3.注册配置类
        applicationContext.register(AppConfig.class);
        //4.刷新容器
        applicationContext.refresh();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }

        //关闭SpringIOC容器
        applicationContext.close();

        //org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        //org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        //org.springframework.context.annotation.internalRequiredAnnotationProcessor
        //org.springframework.context.event.internalEventListenerProcessor
        //org.springframework.context.event.internalEventListenerFactory
        //appConfig
        //dataSourceTest

    }
}

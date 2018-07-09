package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * 自定义监听事件
     * 实现ApplicationListener<E extends ApplicationEvent>接口
     *
     * ContextRefreshedEvent：容器刷新事件
     * ContextClosedEvent：容器关闭事件
     *
     * 如何发布一个事件呢？
     * applicationContext.publishEvent
     *
     * 可以使用注解@EventListener来实现非入侵式监听事件。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.close();
    }

    //收到事件：org.springframework.context.event.ContextRefreshedEvent[source=org.springframework.context.annotation.AnnotationConfigApplicationContext@2b2948e2: startup date [Mon Jul 09 11:55:09 CST 2018]; root of context hierarchy]
    //收到事件：org.springframework.context.event.ContextClosedEvent[source=org.springframework.context.annotation.AnnotationConfigApplicationContext@2b2948e2: startup date [Mon Jul 09 11:55:09 CST 2018]; root of context hierarchy]
}

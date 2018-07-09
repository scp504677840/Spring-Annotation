package main;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService {

    /**
     * 监听ContextRefreshedEvent和ContextClosedEvent事件
     *
     * @param event 当前事件
     */
    @EventListener({ContextRefreshedEvent.class, ContextClosedEvent.class})
    public void printListener(ApplicationEvent event) {
        System.out.println("收到事件：" + event);
    }
    //收到事件：org.springframework.context.event.ContextRefreshedEvent[source=org.springframework.context.annotation.AnnotationConfigApplicationContext@2b2948e2: startup date [Mon Jul 09 12:14:48 CST 2018]; root of context hierarchy]
    //收到事件：org.springframework.context.event.ContextClosedEvent[source=org.springframework.context.annotation.AnnotationConfigApplicationContext@2b2948e2: startup date [Mon Jul 09 12:14:48 CST 2018]; root of context hierarchy]

}

package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountInfo accountInfo = applicationContext.getBean(AccountInfo.class);
        System.out.println(accountInfo);

        // 获取Bean的名称
        String[] names = applicationContext.getBeanNamesForType(AccountInfo.class);
        for (String name: names) {
            System.out.println(name);
        }
    }
}

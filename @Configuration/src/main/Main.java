package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountInfo accountInfo = applicationContext.getBean(AccountInfo.class);
        System.out.println(accountInfo);
    }
}

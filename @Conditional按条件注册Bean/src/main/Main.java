package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Map<String, AccountInfo> beans = applicationContext.getBeansOfType(AccountInfo.class);
        beans.forEach((s, accountInfo) -> {
            System.out.println(accountInfo);
        });
    }
}

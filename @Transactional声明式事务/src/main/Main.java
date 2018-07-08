package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AccountInfoService accountInfoService = (AccountInfoService) ctx.getBean("accountInfoService");
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Tom111");
        accountInfo.setBalance(BigDecimal.valueOf(999L));
        accountInfoService.saveAccountInfo(accountInfo);
    }
}

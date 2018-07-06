package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * 注解@Conditional：按条件注册组件
 * 1.标记类：按条件注册整个类中的组件
 */
//@Conditional({JackCondition.class})
@Configuration
public class AppConfig {

    /**
     * 注解@Conditional：按条件注册组件
     * 1.标记类：按条件注册整个类中的组件
     * 2.标记方法：按条件注册指定组件
     *
     * @return
     */
    @Conditional({JackCondition.class})
    @Bean(value = "jack")
    public AccountInfo jack() {
        System.out.println("jack被创建。");
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(3L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Jack");
        accountInfo.setBalance(BigDecimal.valueOf(7777L));
        return accountInfo;
    }

    @Conditional({TomCondition.class})
    @Bean(value = "tom")
    public AccountInfo tom() {
        System.out.println("tom被创建。");
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(5L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Tom");
        accountInfo.setBalance(BigDecimal.valueOf(5555L));
        return accountInfo;
    }

}

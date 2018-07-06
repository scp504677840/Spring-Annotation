package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * 注解@Configuration代替了原来的配置文件
 * 1.告诉spring这是一个配置类
 */
@Configuration
public class SpringConfig {

    /**
     * 注解@Bean
     * 给spring ioc 容器注册一个Bean；
     * 1.类型为返回值的类型。
     * 2.id默认为方法名。
     *
     * @return
     */
    @Bean
    public AccountInfo accountInfo() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(3L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Tom");
        accountInfo.setBalance(BigDecimal.valueOf(5555L));
        return accountInfo;
    }

}

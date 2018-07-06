package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * 注解@Configuration代替了原来的配置文件
 * 1.告诉spring这是一个配置类
 */
@Configuration

//注解@ComponentScan指定扫描组件的规则
@ComponentScan(value = "main",
        //指定排除哪些组件
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
        //指定只包含哪些组件
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
        //使用只包含时必须将useDefaultFilters置为false。
        useDefaultFilters = false)
public class SpringConfig {

    /**
     * 注解@Bean
     * 给spring ioc 容器注册一个Bean；
     * 1.类型为返回值的类型。
     * 2.id默认为方法名。
     *
     * @return
     */
    @Bean(value = "accountInfo")
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

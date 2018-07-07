package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 注解@PropertySource：引入外部配置文件
 */
@Configuration
@PropertySource(value = {"classpath:/main/accountInfo.properties"})
@ComponentScan("main")
public class AppConfig {

    @Bean
    public AccountInfo accountInfo() {
        return new AccountInfo();
    }

}

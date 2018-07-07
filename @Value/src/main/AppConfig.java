package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/main/accountInfo.properties"})
@ComponentScan("main")
public class AppConfig {

    @Bean
    public AccountInfo accountInfo() {
        return new AccountInfo();
    }

}

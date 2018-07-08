package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("main")
public class AppConfig {

    @Primary
    @Bean
    public AccountInfo accountInfo() {
        return new AccountInfo();
    }

}

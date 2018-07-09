package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 */
@Configuration
@ComponentScan("main")
public class AppConfig {

    @Bean
    public AccountInfo accountInfo(){
        return new AccountInfo();
    }

}

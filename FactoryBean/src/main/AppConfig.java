package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AccountInfoFactoryBean accountInfoFactoryBean(){
        return new AccountInfoFactoryBean();
    }

}

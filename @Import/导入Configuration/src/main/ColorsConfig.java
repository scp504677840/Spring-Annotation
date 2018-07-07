package main;

import main.entities.Orange;
import main.entities.Yellow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColorsConfig {

    @Bean
    public Yellow yellow() {
        return new Yellow();
    }

    @Bean
    public Orange orange() {
        return new Orange();
    }

}

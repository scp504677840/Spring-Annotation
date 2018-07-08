package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 注解@EnableAspectJAutoProxy使AspectJ注解起作用：自动为匹配的类生成代理对象
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("main")
public class AppConfig {

    @Bean
    public ArithmeticCalculator arithmeticCalculator() {
        return new ArithmeticCalculatorImpl();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

}

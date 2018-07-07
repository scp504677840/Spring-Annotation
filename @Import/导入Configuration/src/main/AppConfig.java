package main;

import main.entities.Blue;
import main.entities.Red;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 注解@Import导入Bean
 */
@Import({Red.class, Blue.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class, ColorsConfig.class})
@Configuration
public class AppConfig {
}

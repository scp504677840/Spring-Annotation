package main;

import main.entities.Purple;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入类定义注册器
 * 1.实现ImportBeanDefinitionRegistrar
 * 2.@Import({MyImportBeanDefinitionRegistrar.class})
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 注册Bean
     *
     * @param annotationMetadata     当前类的注解信息
     * @param beanDefinitionRegistry Bean注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 是否包含Red Bean 和 Blue Bean
        boolean red = beanDefinitionRegistry.containsBeanDefinition("main.entities.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("main.entities.Blue");
        // 当包含Red Bean 和 Blue Bean时
        if (red && blue) {
            // 注册Purple Bean
            BeanDefinition beanDefinition = new RootBeanDefinition(Purple.class);
            beanDefinitionRegistry.registerBeanDefinition("purple", beanDefinition);
        }
    }
}

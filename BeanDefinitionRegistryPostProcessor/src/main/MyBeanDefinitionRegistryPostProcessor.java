package main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * BeanDefinitionRegistryPostProcessor继承自BeanFactoryPostProcessor
 * 1.先于BeanFactoryPostProcessor执行。
 * 2.可以在postProcessBeanDefinitionRegistry注册自己的Bean。
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        int count = beanDefinitionRegistry.getBeanDefinitionCount();
        System.out.println("MyBeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry count: " + count);
        BeanDefinition beanDefinition = new RootBeanDefinition(AccountInfo.class);
        beanDefinitionRegistry.registerBeanDefinition("hi", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        int count = configurableListableBeanFactory.getBeanDefinitionCount();
        System.out.println("MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory count: " + count);
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println("MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory name: " + name);
        }
    }
}

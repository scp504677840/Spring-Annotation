package main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactory处理器
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        int count = configurableListableBeanFactory.getBeanDefinitionCount();
        System.out.println("MyBeanFactoryPostProcessor#postProcessBeanFactory count: " + count);
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println("MyBeanFactoryPostProcessor#postProcessBeanFactory name: " + name);
        }
    }
}

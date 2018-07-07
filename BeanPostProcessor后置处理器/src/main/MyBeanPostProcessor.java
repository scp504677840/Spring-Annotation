package main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 调用时机：Bean初始化之前
     *
     * @param bean     当前正在初始化的Bean
     * @param beanName 当前正在初始化Bean的名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization: " + beanName + "-" + bean);
        return bean;
    }

    /**
     * 调用时机：Bean初始化之后
     *
     * @param bean     当前正在初始化的Bean
     * @param beanName 当前正在初始化Bean的名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization: " + beanName + "-" + bean);
        return bean;
    }
}

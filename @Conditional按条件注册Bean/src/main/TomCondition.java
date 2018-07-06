package main;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TomCondition implements Condition {

    /**
     * 匹配
     *
     * @param conditionContext      条件上下文
     * @param annotatedTypeMetadata 要检查的类或方法的元数据
     * @return true：注册Bean，否则不注册。
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //下面是可以获取到的资源
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        ClassLoader classLoader = conditionContext.getClassLoader();
        ResourceLoader resourceLoader = conditionContext.getResourceLoader();
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        //当前毫秒数为奇数时，允许注册该Bean
        return System.currentTimeMillis() % 2 != 0;
    }
}

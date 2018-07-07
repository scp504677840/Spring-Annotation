package main;

import main.entities.AccountInfo;
import org.springframework.beans.factory.FactoryBean;

/**
 * 由BeanFactory中使用的对象实现的接口，这些对象本身就是单个对象的工厂。
 * 如果bean实现了这个接口，它将被用作公开的对象的工厂，而不是直接作为将自己公开的bean实例。
 * 注意：
 * 实现此接口的bean不能用作普通bean。
 * FactoryBean以bean样式定义，但为bean引用公开的对象（getObject（））始终是它创建的对象。
 *
 * 如果想得到AccountInfoFactoryBean本身，则需要在BeanName前面加上 '&' 符号，如：&accountInfoFactoryBean
 */
public class AccountInfoFactoryBean implements FactoryBean<AccountInfo> {

    @Override
    public AccountInfo getObject() throws Exception {
        System.out.println("call AccountInfoFactoryBean#getObject");
        return new AccountInfo();
    }

    @Override
    public Class<?> getObjectType() {
        return AccountInfo.class;
    }

    /**
     * 是否为单例
     *
     * @return true：单例。false：多实例。
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}

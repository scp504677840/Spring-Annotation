package main;

import main.entities.AccountInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /**
     * Bean的生命周期
     * 创建-初始化-销毁
     *
     * initMethod：指定初始化方法
     * destroyMethod：指定销毁方法
     *
     * 下面有两种情况需要讨论：
     * 1.单实例
     *  Bean的整个生命周期都交给SpringIOC容器来管理。
     * 2.多实例
     *  非常重要！！！
     *  2-1.如果Bean不使用，就不会在SpringIOC容器启动时创建和初始化。只有当使用到该Bean时，才会创建并初始化该Bean的实例。
     *  2-2.Bean的创建和初始化生命周期交给SpringIOC容器来管理，但是销毁由开发者自己管理。
     *
     * @return
     */
    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AccountInfo accountInfo() {
        return new AccountInfo();
    }

}

package main;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Web容器启动时创建对象，调用方法来初始化容器
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取根容器的配置类（Spring的配置文件）
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 获取Web容器的配置类（SpringMVC配置文件）子容器。
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 获取DispatcherServlet的映射信息
     * /：拦截所有请求。（包括静态资源，但不包括*.jsp）
     * /*：拦截所有请求。（包括静态资源，但包括*.jsp）
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

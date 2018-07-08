package main;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 注解@Profile也可以标记在类上
 * 当标记在类上时，若当前环境未激活时，则该配置文件不生效。
 */
//@Profile("pro")
@Configuration
@PropertySource("classpath:/main/db.properties")
@ComponentScan("main")
public class AppConfig implements EmbeddedValueResolverAware {

    /**
     * user
     */
    @Value("${user}")
    private String user;

    /**
     * driverClass
     */
    private String driverClass;

    @Profile("test")
    @Bean
    public DataSource dataSourceTest(@Value("${password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://192.168.0.101:3306/test");
        return dataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev(@Value("${password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://192.168.0.101:3306/dev");
        return dataSource;
    }

    @Profile("pro")
    @Bean
    public DataSource dataSourcePro(@Value("${password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://192.168.0.101:3306/pro");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        driverClass = stringValueResolver.resolveStringValue("${driverClass}");
    }
}

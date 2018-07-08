package main;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 注解@EnableAspectJAutoProxy使AspectJ注解起作用：自动为匹配的类生成代理对象
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/db.properties")
@ComponentScan("main")
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(env.getProperty("user"));
        dataSource.setPassword(env.getProperty("password"));
        dataSource.setJdbcUrl(env.getProperty("jdbcUrl"));
        dataSource.setDriverClass(env.getProperty("driverClass"));
        Integer initPoolSize = env.getProperty("initPoolSize", Integer.class);
        dataSource.setMinPoolSize(initPoolSize == null ? 5 : initPoolSize);
        Integer maxPoolSize = env.getProperty("maxPoolSize", Integer.class);
        dataSource.setMaxPoolSize(maxPoolSize == null ? 10 : maxPoolSize);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager txManager() throws PropertyVetoException {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource());
        return txManager;
    }
}

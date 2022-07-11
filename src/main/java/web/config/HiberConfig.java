package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HiberConfig {
    private Environment env;
    @Autowired
    public HiberConfig(Environment env){
        this.env = env;
    }

    @Bean("emf")
    public LocalContainerEntityManagerFactoryBean EntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lcemFB =
                new LocalContainerEntityManagerFactoryBean();
        lcemFB.setDataSource(getDataSource());
        lcemFB.setPackagesToScan("web.entity");
        lcemFB.setJpaProperties(hibernateProp());
        lcemFB.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return lcemFB;
    }
    final Properties hibernateProp(){
        Properties hiber = new Properties();
        hiber.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hiber.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hiber.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return hiber;
    }
    @Bean
    public DataSource getDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(EntityManagerFactory().getObject());
        transactionManager.setDataSource(getDataSource());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }


}

package edu.nathan.finance.service.demo.config;

import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
@Profile("k8s")
public class DBInitConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBInitConfiguration.class);

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        // https://stackoverflow.com/questions/65351356/initialize-database-for-testing-purpose-on-spring-data-r2dbc
        // https://github.com/spring-projects/spring-boot/issues/20524
        // https://cloud.tencent.com/developer/article/2168686
        // https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
        LOGGER.info("DBInitConfiguration: initializer");

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("init-db/postgress.sql")));
        initializer.setDatabasePopulator(populator);


        return initializer;
    }
}

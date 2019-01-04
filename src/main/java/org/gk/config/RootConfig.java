package org.gk.config;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages={"org.gk.business"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {

        @Bean
        public DataSource dataSource() {
                EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
                EmbeddedDatabase db = builder
                        .setType(EmbeddedDatabaseType.HSQL)
                        .addScript("db/sql/create-db.sql")
                        .addScript("db/sql/insert-data.sql")
                        .build();
                return db;
        }

        @PostConstruct
        public void startDbManager() {
                DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});
        }
}

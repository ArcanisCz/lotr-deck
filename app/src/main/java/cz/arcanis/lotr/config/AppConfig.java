package cz.arcanis.lotr.config;

import com.mongodb.MongoClient;
import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Arcanis on 12.7.2015.
 */
@Configuration
@EnableVaadin
//@EnableJpaRepositories("cz.arcanis.lotr.backend.repository")
@EnableMongoRepositories("cz.arcanis.lotr.backend.repository")
@ComponentScan(basePackages = {
        "cz.arcanis.lotr.vaadin",
        "cz.arcanis.lotr.backend"
})
public class AppConfig {

    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient("localhost:27000");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "lotr");
    }
}

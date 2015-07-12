package cz.arcanis.lotr.config;

import com.mongodb.MongoClient;
import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
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
        MongoClient mongo = new MongoClient("localhost:27000");
        return mongo;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate template = new MongoTemplate(mongo(), "lotr", new UserCredentials("admin", "szwFfL4P3u4g"));
        return template;
    }
}

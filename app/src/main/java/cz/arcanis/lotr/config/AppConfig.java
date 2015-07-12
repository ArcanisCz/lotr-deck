package cz.arcanis.lotr.config;

import com.mongodb.MongoClient;
import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Arcanis on 12.7.2015.
 */
@Configuration
@EnableVaadin
@EnableMongoRepositories("cz.arcanis.lotr.backend.repository")
@ComponentScan(basePackages = {
        "cz.arcanis.lotr.vaadin",
        "cz.arcanis.lotr.backend"
})
public class AppConfig {

    @Bean
    public MongoDbFactory mongo() throws Exception {
//        MongoClient client = new MongoClient("localhost", 27000);
        MongoClient client = new MongoClient("127.8.179.130", 27017);
        MongoDbFactory factory = new SimpleMongoDbFactory(client, "lotr", new UserCredentials("reader1", "pokus"));
//        MongoClient mongo = new MongoClient("127.8.179.130", 27017);

        return factory;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate template = new MongoTemplate(mongo());
        return template;
    }
}

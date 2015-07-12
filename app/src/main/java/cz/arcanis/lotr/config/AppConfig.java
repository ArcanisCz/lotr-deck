package cz.arcanis.lotr.config;

import com.mongodb.Mongo;
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
@EnableMongoRepositories("cz.arcanis.lotr.backend.repository")
@ComponentScan(basePackages = {
        "cz.arcanis.lotr.vaadin",
        "cz.arcanis.lotr.backend"
})
public class AppConfig {

//    @Bean
//    public MongoDbFactory mongo() throws Exception {
//        MongoCredential.createPlainCredential("reader1", "pokus", "pokus".toCharArray());
//        MongoClient client = new MongoClient("ds059712.mongolab.com", 59712);
////        MongoClient client = new MongoClient("127.8.179.130", 27017);
//        MongoDbFactory factory = new SimpleMongoDbFactory(client, "lotr");
////        MongoClient mongo = new MongoClient("127.8.179.130", 27017);
//
//        return factory;
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        MongoTemplate template = new MongoTemplate(mongo());
//        return template;
//    }

    @Bean
    public Mongo mongo() throws Exception {
//        return new Mongo("ds059712.mongolab.com", 59712);
        return new Mongo("127.8.179.130", 27017);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "lotr", new UserCredentials("reader1", "pokus"));
    }
}

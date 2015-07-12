package cz.arcanis.lotr.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.vaadin.spring.annotation.EnableVaadin;
import cz.arcanis.lotr.model.entity.converter.CardReadConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

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
    public Mongo mongo() throws Exception {
//        return new MongoClient("localhost", 27000);
        return new Mongo("127.8.179.130", 27017);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
//        MongoTemplate template = new MongoTemplate(mongo(), "lotr");
        MongoTemplate template = new MongoTemplate(mongo(), "lotr", new UserCredentials("reader2", "pokus"));

        CustomConversions customConversions = new CustomConversions(Arrays.asList(new Converter[]{new CardReadConverter()}));
        MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
        converter.setCustomConversions(customConversions);

        converter.afterPropertiesSet();

        return template;
    }
}

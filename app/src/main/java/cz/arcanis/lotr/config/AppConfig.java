package cz.arcanis.lotr.config;

import com.mongodb.Mongo;
import com.vaadin.spring.annotation.EnableVaadin;
import cz.arcanis.lotr.model.entity.converter.CardReadConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
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
@PropertySource(value = "classpath:properties.properties")
public class AppConfig {

    @Value("${mongo.host}")
    private String mongoHost;

    @Value("${mongo.port}")
    private String mongoPort;

    @Value("${mongo.user}")
    private String mongoUser;

    @Value("${mongo.password}")
    private String mongoPassword;

    @Value("${mongo.db}")
    private String mongoDb;

    @Bean
    public Mongo mongo() throws Exception {
        return new Mongo(mongoHost, Integer.parseInt(mongoPort));
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate template;
        if(StringUtils.isBlank(mongoUser) && StringUtils.isBlank(mongoPassword)){
            template= new MongoTemplate(mongo(), mongoDb);
        }else{
            template = new MongoTemplate(mongo(), mongoDb, new UserCredentials(mongoUser, mongoPassword));
        }

        CustomConversions customConversions = new CustomConversions(Arrays.asList(new Converter[]{new CardReadConverter()}));
        MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
        converter.setCustomConversions(customConversions);

        converter.afterPropertiesSet();

        return template;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

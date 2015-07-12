package cz.arcanis.lotr.config;

import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Arcanis on 12.7.2015.
 */
@Configuration
@EnableVaadin
@ComponentScan(basePackages = {
        "cz.arcanis.lotr",
        "cz.arcanis.lotr.data"
})
public class AppConfig {
}

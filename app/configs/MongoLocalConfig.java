package configs;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
@PropertySource("classpath:mongo.properties")
@Profile("mongodb-local")
public class MongoLocalConfig {
	
	@Value("${mongodb.databasename}")
	String mongodb_databasename;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        try {
            return new SimpleMongoDbFactory(new MongoClient(), mongodb_databasename);
        } catch (UnknownHostException e) {
            throw new RuntimeException("Error creating MongoDbFactory: " + e);
        }
    }

}

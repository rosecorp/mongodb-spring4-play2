package configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan
@EnableMongoRepositories(basePackages = "repository")
@PropertySource("classpath:mongo.properties")
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Value("${mongodb.host}")
	String mongodb_host;

	@Value(value="${mongodb.port}")
	Integer mongodb_port;

	@Value("${mongodb.databasename}")
	String mongodb_databasename;

	@Override
	protected String getDatabaseName() {
		return mongodb_databasename;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(mongodb_host, mongodb_port);
	}
}

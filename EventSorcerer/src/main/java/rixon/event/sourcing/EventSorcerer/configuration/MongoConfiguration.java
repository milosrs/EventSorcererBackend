package rixon.event.sourcing.EventSorcerer.configuration;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {
	@Autowired
	private ConfigProperties configProperties;
	
	private static final String URI_PROPERTY_KEY = "spring.data.mongodb.uri";
	private static final String DB_NAME = "EventSorcerer";
	
	public MongoClient mongoClient() {
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        
        return MongoClients.create(MongoClientSettings.builder()
                                                      .applyConnectionString(new ConnectionString(configProperties.getConfigValue(URI_PROPERTY_KEY)))
                                                      .codecRegistry(codecRegistry)
                                                      .build());
	}

	@Override
	protected String getDatabaseName() {
		return DB_NAME;
	}
}

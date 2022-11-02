package io.doosti.hamid.reactivespring.config;

import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@EnableReactiveMongoRepositories
public class DataConfig extends AbstractReactiveMongoConfiguration{

	
	@Override
	public MongoClient reactiveMongoClient() {
		// TODO Auto-generated method stub
		return MongoClients.create("mongodb://localhost:27017");
	}
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "reactivespring";
	}

}

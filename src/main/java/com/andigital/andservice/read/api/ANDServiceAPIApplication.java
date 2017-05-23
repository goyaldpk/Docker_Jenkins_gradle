package com.andigital.andservice.read.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClientOptions.Builder;

/**
 * @author premsingh
 * SpringBoot Main class.
 */
@SpringBootApplication
public class ANDServiceAPIApplication {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(ANDServiceAPIApplication.class, args);
	}

//TODO: Need to get the configuration details from properties file.	
	@Bean(name = "mongoclient")
	@Scope("singleton")
	public MongoClient mongoclient() throws Exception {

		Builder builder = new MongoClientOptions.Builder();
		builder.connectionsPerHost(20);
		builder.connectTimeout(2000);
		builder.minConnectionsPerHost(2);

		MongoProperties mongoproperties = context.getBean(MongoProperties.class);
		List<MongoCredential> credentialsList = new ArrayList<>();
		MongoCredential credential = MongoCredential.createCredential(mongoproperties.getUsername(),
				mongoproperties.getDatabase(), mongoproperties.getPassword());
		credentialsList.add(credential);
		ServerAddress addr = new ServerAddress(mongoproperties.getHost(), mongoproperties.getPort());

		return new MongoClient(addr, credentialsList, builder.build());

	}
}

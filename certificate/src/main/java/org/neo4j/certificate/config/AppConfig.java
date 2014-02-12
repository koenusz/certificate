package org.neo4j.certificate.config;

import org.neo4j.certificate.application.AppTestService;
import org.neo4j.certificate.util.MessageService;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("org.neo4j.certificate.repository")
@ComponentScan("org.neo4j.certificate.*")
public class AppConfig extends Neo4jConfiguration {

	private final String LOCALSERVER = "http://localhost:7474/db/data/";
	
	
	@Bean
	MessageService appTestService() {
		return new AppTestService();
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {
		// if you want to use Neo4j as a REST service
		// return new SpringRestGraphDatabase(LOCALSERVER);
		// Use Neo4j as Odin intended (as an embedded service)

		
		
		GraphDatabaseService service = GraphDbStarter.getInstance();
		return service;
	}
}
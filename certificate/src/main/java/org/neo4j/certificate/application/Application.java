package org.neo4j.certificate.application;

import java.io.File;

import org.neo4j.certificate.config.AppConfig;
import org.neo4j.certificate.repository.CertificateRepository;
import org.neo4j.certificate.util.MessagePrinter;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.core.GraphDatabase;

@Configuration
@Import(AppConfig.class)
public class Application implements CommandLineRunner {

	@Autowired
	AppConfig appConfig;

	@Autowired
	GraphDatabase graphDatabase;

	@Autowired
	CertificateRepository certificateRepository;

	@Autowired
	AppTest appTest;

	@Autowired
	MessagePrinter messagePrinter;


	@Override
	public void run(String... arg0) throws Exception {

		appTest.testSave();
		messagePrinter.setPrintMessage(appTest.testRetrieve());

		messagePrinter.printMessage();

	}

	public static void main(String[] args) throws Exception {
		FileUtils.deleteRecursively(new File("/tmp/graphdb"));

		SpringApplication.run(Application.class, args);
	}

}

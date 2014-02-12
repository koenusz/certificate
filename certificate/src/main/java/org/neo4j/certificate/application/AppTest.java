package org.neo4j.certificate.application;

import org.neo4j.certificate.domain.Certificate;
import org.neo4j.certificate.domain.Document;
import org.neo4j.certificate.repository.CertificateRepository;
import org.neo4j.certificate.repository.DocumentRepository;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.stereotype.Component;

@Component
public class AppTest {

	@Autowired
	CertificateRepository certificateRepository;

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	GraphDatabase graphDatabase;

	public void testSave() {
		Certificate cert1 = new Certificate();
		cert1.setName("test1");

		Certificate cert2 = new Certificate();
		cert2.setName("test2");
		Certificate cert3 = new Certificate();
		cert3.setName("test3");

		certificateRepository.save(cert1);
		certificateRepository.save(cert2);
		certificateRepository.save(cert3);

		Document doc1 = new Document();
		doc1.setTitle("document1");
		documentRepository.save(doc1);

	}

	public String testRetrieve() {

		StringBuffer result = new StringBuffer();

		try (Transaction tx = graphDatabase.beginTx()) {
			Iterable<Certificate> certs = certificateRepository.findAll();
			int testint = 0;

			for (Certificate cert : certs) {
				System.out.println("cert " + testint);
				testint++;
				result.append(cert.getName() + " ");
			}

			Iterable<Document> docs = documentRepository.findAll();
			for (Document doc : docs) {
				System.out.println("doc " + testint);
				testint++;
				result.append(doc.getTitle() + " ");
			}
			tx.success();
		}

		return result.toString();
	}

}

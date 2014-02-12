/*package nl.neo4j.repository;

import org.aspectj.lang.annotation.Before;
import org.neo4j.certificate.domain.Certificate;
import org.neo4j.certificate.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CertificateTest {

	@Autowired
	CertificateRepository repo;

	@Before
	public void initDB() {

		Certificate cert = new Certificate();
		cert.setName("test1");
		repo.save(cert);
		// cert.setOwner(owner);

	}

	@Test
	public void getCertificateByNamTtest() {
		Certificate cert = repo.findByPropertyValue("name", "test1");

		assert (cert.getName().equals("test1"));

	}

	@Test
	public void getCertificatestest() {
		Iterable<Certificate> certificates = repo.findAll();

		int count = 0;
		for (Certificate cert : certificates) {

			count++;
		}
		assert (count == 1);
	}

	
	 * @Test public void getCertificateUserTest() { Iterable<User> users =
	 * repo.getRatings(cert); }
	 
}
*/
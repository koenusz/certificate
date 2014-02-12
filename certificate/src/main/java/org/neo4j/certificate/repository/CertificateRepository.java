package org.neo4j.certificate.repository;

import org.neo4j.certificate.domain.Certificate;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface CertificateRepository extends GraphRepository<Certificate>  {
	
	/* @Query("start certificate={0} match m<-[rating:RATED]-user return user")
	  
	        		  Iterable<User> getRatings(Certificate cert);*/


}

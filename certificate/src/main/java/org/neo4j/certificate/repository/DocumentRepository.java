package org.neo4j.certificate.repository;

import org.neo4j.certificate.domain.Document;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface DocumentRepository extends GraphRepository<Document>  {
	
	/* @Query("start certificate={0} match m<-[rating:RATED]-user return user")
	  
	        		  Iterable<User> getRatings(Certificate cert);*/


}

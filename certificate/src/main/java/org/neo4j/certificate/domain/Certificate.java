package org.neo4j.certificate.domain;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * @author kjwva_000
 * 
 */
@NodeEntity
public class Certificate {

	@GraphId
	Long id;

	@Indexed(indexName = "search")
	String name;

	@RelatedTo(type = "SUPPORT", direction = Direction.BOTH)
	public @Fetch
	Set<Document> documents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

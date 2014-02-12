package org.neo4j.certificate.domain;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Document {

	@GraphId
	Long id;

	String title;

	@RelatedTo(type = "SUPPORT", direction = Direction.BOTH)
	public @Fetch
	Set<Certificate> certificates;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		String results = title;

		return results;
	}

}

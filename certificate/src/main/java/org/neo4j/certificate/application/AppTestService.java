package org.neo4j.certificate.application;

import org.neo4j.certificate.util.MessageService;


public class AppTestService implements MessageService {

	String message;
	
	@Override
	public String getMessage() {
		
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}

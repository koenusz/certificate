package org.neo4j.certificate.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	@Autowired
	private MessageService service;

	public void setPrintMessage(String message) {
		service.setMessage(message);
	}

	public void printMessage() {
		System.out.println(this.service.getMessage());
	}

}

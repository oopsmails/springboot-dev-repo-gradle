package com.oopsmails.genericjava.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service")
@Data
public class ServiceProperties {

	/**
	 * A message for the service.
	 */
	private String message;

//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
}

package com.oopsmails.genericjava.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(com.oopsmails.genericjava.service.ServiceProperties.class)
@Slf4j
public class MyService {

	private final com.oopsmails.genericjava.service.ServiceProperties serviceProperties;

	public MyService(com.oopsmails.genericjava.service.ServiceProperties serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

	public String message() {
		log.info("this.serviceProperties.getMessage(): [{}]", this.serviceProperties.getMessage());
		return this.serviceProperties.getMessage();
	}
}

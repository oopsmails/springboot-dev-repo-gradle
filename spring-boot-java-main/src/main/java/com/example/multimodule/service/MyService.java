package com.example.multimodule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ServiceProperties.class)
@Slf4j
public class MyService {

	private final ServiceProperties serviceProperties;

	public MyService(ServiceProperties serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

	public String message() {
		log.info("this.serviceProperties.getMessage(): [{}]", this.serviceProperties.getMessage());
		return this.serviceProperties.getMessage();
	}
}

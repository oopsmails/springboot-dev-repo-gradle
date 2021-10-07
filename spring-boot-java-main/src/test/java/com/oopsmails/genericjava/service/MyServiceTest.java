package com.oopsmails.genericjava.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.oopsmails.genericjava.service.MyService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("service.message=Hello")
public class MyServiceTest {

	@Autowired
	private MyService myService;

	@Test
	public void contextLoads() {
//		assertThat(myService.message()).isNotNull();
	}

	@Test
	public void serviceMessageNotNull() {
		assertThat(myService.message()).isNotNull();
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}

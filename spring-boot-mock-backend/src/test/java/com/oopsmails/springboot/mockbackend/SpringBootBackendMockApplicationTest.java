package com.oopsmails.springboot.mockbackend;

import com.oopsmails.genericjava.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest("service.message=Hello in SpringBootBackendMockApplicationTest")
public class SpringBootBackendMockApplicationTest {
    @Autowired
    private MyService myService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void serviceMessageNotNull() {
        assertThat(myService.message()).isNotNull();
    }
}

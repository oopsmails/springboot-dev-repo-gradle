package com.oopsmails.springboot.mockbackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@SpringBootApplication //(scanBasePackages = "com.oopsmails.genericjava")
@ComponentScan("com.oopsmails.genericjava")
@Slf4j
public class SpringBootBackendMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBackendMockApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }

    /**
     * Not really using, just for demo example purpose here.
     */
    @RestController
    class FileResource {

        @GetMapping("/")
        public String getGradleBasics() {
            log.info("calling ............... spring-boot-mock-backend,  getGradleBasics.");
            return "Hello, from spring-boot-mock-backend project !";
        }

        @GetMapping(path = "/api/files", produces = MediaType.TEXT_PLAIN_VALUE)
        public ResponseEntity<String> getFile() {
            String exportedContent = "Hello, World!";
            String filename = "my-file.txt";
            HttpHeaders headers = new HttpHeaders();
            headers.setAccessControlExposeHeaders(Collections.singletonList("Content-Disposition"));
            headers.set("Content-Disposition", "attachment; filename=" + filename);
            return new ResponseEntity<>(exportedContent, headers, HttpStatus.OK);
        }

    }
}

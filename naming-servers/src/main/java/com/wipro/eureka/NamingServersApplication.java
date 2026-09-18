package com.wipro.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NamingServersApplication {

    public static void main(String[] args) {
        SpringApplication.run(NamingServersApplication.class, args);
    }

}
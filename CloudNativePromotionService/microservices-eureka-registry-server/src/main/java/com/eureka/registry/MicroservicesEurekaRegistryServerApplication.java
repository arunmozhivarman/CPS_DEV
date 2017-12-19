package com.eureka.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesEurekaRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesEurekaRegistryServerApplication.class, args);
	}
}

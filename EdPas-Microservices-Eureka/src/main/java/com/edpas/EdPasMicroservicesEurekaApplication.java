package com.edpas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EdPasMicroservicesEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdPasMicroservicesEurekaApplication.class, args);
	}

}

package com.edpas;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class EdPasMicroservicesAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdPasMicroservicesAuthServerApplication.class, args);
	}
	
	@GetMapping("/user")
	public Principal getUser(Principal user) {
		return user;
	}

}

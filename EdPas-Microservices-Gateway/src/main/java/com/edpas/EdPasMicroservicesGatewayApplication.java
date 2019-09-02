package com.edpas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EdPasMicroservicesGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdPasMicroservicesGatewayApplication.class, args);
	}

}

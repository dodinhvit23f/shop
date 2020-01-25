package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ShopServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServerApplication.class, args);
	}

}

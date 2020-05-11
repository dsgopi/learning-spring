package com.projects.accounts.mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringAccountsMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAccountsMgmtApplication.class, args);
	}

}

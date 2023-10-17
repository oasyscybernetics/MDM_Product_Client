package com.oasys.mdmclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.oasys.mdmclient.*")
////@EnableAdminServer
//@EnableJpaRepositories(basePackages = { "com.oasys.mdmclient.repository" })
//@EntityScan(basePackages = { "com.oasys.mdmclient.entity" })
public class MdmclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdmclientApplication.class, args);
	}

}

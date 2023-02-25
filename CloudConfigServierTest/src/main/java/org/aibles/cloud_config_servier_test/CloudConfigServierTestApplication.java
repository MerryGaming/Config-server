package org.aibles.cloud_config_servier_test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class CloudConfigServierTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServierTestApplication.class, args);
	}

}

package com.cg.sprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerOnlineMovieTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerOnlineMovieTicketApplication.class, args);
	}

}

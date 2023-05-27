package com.hcmute.edu.vn.OronProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//		(exclude = {SecurityAutoConfiguration.class })
public class OronProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(OronProjectApplication.class, args);
	}

}

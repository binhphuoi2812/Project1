package com.trungtamjava.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.trungtamjava")
public class Maven02Application {

	public static void main(String[] args) {
		SpringApplication.run(Maven02Application.class, args);
	}

}

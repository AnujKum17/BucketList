package com.logmein.challenge.bucketedit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.logmein.challenge.bucketedit")
public class BucketEditApplication{
	public static void main(String[] args) {
		SpringApplication.run(BucketEditApplication.class, args);
	}
}

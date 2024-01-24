package com.springbootsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages={"com.*"})
@EntityScan( basePackages = {"com.*"} )
public class SpringBootSoapWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapWebServiceApplication.class, args);
	}

}

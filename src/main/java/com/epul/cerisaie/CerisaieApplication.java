package com.epul.cerisaie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CerisaieApplication  extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CerisaieApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CerisaieApplication.class, args);
	}
}



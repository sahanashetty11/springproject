package com.example.demo.springproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@SpringBootApplication
public class SpringprojectApplication {
	private static final Logger logger= LogManager.getLogger(SpringprojectApplication.class);
	public static void main(String[] args) {
		logger.debug("Hello from Log4j 2");
		logger.info("Staring springggg application");
		logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
		SpringApplication.run(SpringprojectApplication.class, args);
	}

}
//dfbgdfd
//fdsgdcxs
//dsfvbfv
//dfgvbvf
//sdfg
//sdfg
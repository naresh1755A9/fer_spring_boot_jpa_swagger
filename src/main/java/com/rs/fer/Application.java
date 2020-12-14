package com.rs.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource("classpath:${CONFIG_MODE}/application.properties")
public class Application {

	
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}

package com.xiaolin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JavaPracticeApplication {

	public static void main(String[] args) {

		System.out.println("Hello World!");
		SpringApplication.run(JavaPracticeApplication.class, args);
	}

}

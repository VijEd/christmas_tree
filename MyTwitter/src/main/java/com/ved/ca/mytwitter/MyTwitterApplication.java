package com.ved.ca.mytwitter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ved.ca.mytwitter"})
@MapperScan("com.ved.ca.mytwitter.mappers")
public class MyTwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTwitterApplication.class, args);
	}
}

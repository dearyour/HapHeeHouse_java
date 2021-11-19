package com.ssafy.happyhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ssafy.happyhouse.model.dao")
@SpringBootApplication
public class HappyHouse6FinalSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouse6FinalSpringBootApplication.class, args);
	}

}

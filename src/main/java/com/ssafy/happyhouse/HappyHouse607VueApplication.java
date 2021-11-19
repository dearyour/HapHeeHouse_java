package com.ssafy.happyhouse;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.ssafy.happyhouse.model.dao")
@SpringBootApplication
public class HappyHouse607VueApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouse607VueApplication.class, args);
	}

}

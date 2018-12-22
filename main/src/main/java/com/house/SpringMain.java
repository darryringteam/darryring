package com.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.house.dao")
@SpringBootApplication
public class SpringMain {

	public static void main(String[] args) {

		SpringApplication.run(SpringMain.class, args);

	}
}

package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages={"com.example"})
 @MapperScan("com.example.mapper")
//@EnableScheduling
//@ComponentScan(basePackages={"com"})
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

@Bean
public BCryptPasswordEncoder encoder(){
 return new BCryptPasswordEncoder();
}
}

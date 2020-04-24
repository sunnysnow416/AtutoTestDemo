package com.course.chapter11;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

//第二种写法,通用写法
@EnableScheduling
@SpringBootApplication
public class Application {
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Application.context = SpringApplication.run(Application.class, args);
	}
	
	@PreDestroy
	public void close(){
		Application.context.close();
	}

}

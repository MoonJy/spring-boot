package com.eggmoney.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import com.eggmoney.ws.config.ProjectProperties;

@ComponentScan
@SpringBootApplication
@EnableConfigurationProperties({ProjectProperties.class})
@MapperScan("com.eggmoney.ws.dao")
public class Test2Application {
	
/*	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final Environment env;
	private final ProjectProperties projectProperties;

	public Test2Application(Environment env, ProjectProperties projectProperties) {
		this.env = env;
		this.projectProperties = projectProperties;
	}*/



	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}
}

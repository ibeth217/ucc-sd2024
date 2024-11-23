package com.pacheco.ibeth.tablax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.pacheco.ibeth.tablax")
@ComponentScan(basePackages = "com.pacheco.ibeth.tablax")
@EnableJpaRepositories(basePackages = {"com.pacheco.ibeth.tablax"})
@EntityScan(basePackages = {"com.pacheco.ibeth.tablax"})
public class TablaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(TablaxApplication.class, args);
	}

}

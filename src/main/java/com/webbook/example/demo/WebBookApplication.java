package com.webbook.example.demo;

import com.webbook.example.demo.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@EnableCaching
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EntityScan(basePackages = {"com.webbook.example.demo.entity"})
@EnableJpaRepositories(basePackages ={"com.webbook.example.demo.repository"} )
@ComponentScan(basePackages = { "com.webbook.example.demo.web" })

@SpringBootApplication
public class WebBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBookApplication.class, args);
	}
}

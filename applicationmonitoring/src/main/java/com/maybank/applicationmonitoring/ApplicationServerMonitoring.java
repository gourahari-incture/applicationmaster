package com.maybank.applicationmonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.maybank.applicationmonitoring" })
@ComponentScan(basePackageClasses = {ServletInitializer.class, SwaggerConfig.class})
@EnableJpaRepositories(basePackages = { "com.maybank.applicationmonitoring" })
@EntityScan(basePackages = { "com.maybank.applicationmonitoring.entity" })
@SpringBootApplication(exclude = {IntegrationAutoConfiguration.class})
public class ApplicationServerMonitoring {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationServerMonitoring.class, args);
	}

}

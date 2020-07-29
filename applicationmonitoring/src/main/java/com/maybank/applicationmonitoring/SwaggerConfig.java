package com.maybank.applicationmonitoring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	public static final Contact DEFAULT_CONTACT = new Contact("Gourahari Sendha", null, "gourahari.s@maybank.com");

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title", "Awesome API Description", "1.0",
			"urn:tos", DEFAULT_CONTACT, null, null);

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).enable(true).select()
				.apis(RequestHandlerSelectors.basePackage("com.maybank.applicationmonitoring"))
				.paths(PathSelectors.any()).build();
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo getApiInfo() {
		return new ApiInfo("REST Api Documentation", "REST Api Documentation", "1.0", "urn:tos",
				new Contact("", "", ""), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}

//	  @Bean public Docket api() { return new
//	  Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(
//	  DEFAULT_PRODUCES_AND_CONSUMES) .consumes(DEFAULT_PRODUCES_AND_CONSUMES); }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}

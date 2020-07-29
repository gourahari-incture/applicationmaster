package com.maybank.applicationmonitoring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/*
	 * @Bean public ViewResolver viewResolver() { InternalResourceViewResolver bean
	 * = new InternalResourceViewResolver(); bean.setViewClass(JstlView.class);
	 * bean.setPrefix("/WEB-INF/views/"); bean.setSuffix(".jsp"); return
	 * (ViewResolver)bean; }
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(new String[] { "/resources/**" })
				.addResourceLocations(new String[] { "WEB-INF/resources/" });
	}

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}

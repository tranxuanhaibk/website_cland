package edu.vinaenter.cland.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class BeanConfig {
	@Bean
	public ResourceBundleMessageSource messageSource() {
	ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	source.setBasename("messages");
	source.setUseCodeAsDefaultMessage(true);
	source.setDefaultEncoding("UTF-8");
	return source;
	}

}

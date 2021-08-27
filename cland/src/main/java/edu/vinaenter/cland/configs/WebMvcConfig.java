package edu.vinaenter.cland.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan("edu.vinaenter.cland.*")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean 
	public MultipartResolver multipartResolver() { 
	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	//resolver.setMaxUploadSize(1*1024*1024); 
	return resolver; 
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/springmvc/tiles-cland.xml", "/WEB-INF/springmvc/tiles-admin.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("resources/**").addResourceLocations("/WEB-INF/resources/");
	}
}

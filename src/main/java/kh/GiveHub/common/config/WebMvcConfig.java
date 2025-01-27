package kh.GiveHub.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	private String getBasePath() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "file:///c:/GiveHub/";
		}else {
			return "file:///GiveHub.";
		}
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String basePath = getBasePath();
		
		registry.addResourceHandler("/temp/**")
			.addResourceLocations(basePath+"temp/");
		registry.addResourceHandler("/upload/**")
			.addResourceLocations(basePath+"upload/");
		registry.addResourceHandler("/**")
			.addResourceLocations("classpath:/static/");

	}
}

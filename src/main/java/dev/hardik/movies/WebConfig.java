package dev.hardik.movies;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow requests from localhost:3000
        registry.addMapping("/api/**")  // Enable CORS for all API endpoints
                .allowedOrigins("http://localhost:3000")  // Allow localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow specific HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // If you need to support credentials (cookies, authorization headers)
    }
}


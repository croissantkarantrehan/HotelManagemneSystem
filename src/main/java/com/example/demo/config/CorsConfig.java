//package com.example.demo.config;
//
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig {
//
//   // crossdomain vulnerability
//    @Value("${cross.origin.url}")
//    private String[] crossoriginurl;
//    
//    @Bean
//	public CorsConfiguration corsConfiguration() {
//
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowedOrigins(Arrays.asList(crossoriginurl));
//		config.addAllowedMethod("*");
//		config.addAllowedHeader("*");
//		return config;
//	}
//
//	
//	
//	@Bean
//	public CorsFilter corsFilter() {
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfiguration());
//		return new CorsFilter(source);
//	}
//
//}
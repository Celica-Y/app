package com.example.demo.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:application.properties") //アプリケーションプロパティに記述したAPIのURLを使用する。
@ComponentScan
public class WeatherConfig {
	@Value("${weather.url}")
	private String url;
	
	@Value("${weather.apiKey}")
	private String apikey;
	
	
	/** 
	 * RestTemplateをコントローラーで@Autowiredするとbeenがないと怒られる
	 * 解決→https://stackoverflow.com/questions/28024942/how-to-autowire-resttemplate-using-annotations
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
//	@PropertySourceを使用する時の記述
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

		PropertySourcesPlaceholderConfigurer A = new PropertySourcesPlaceholderConfigurer();
		A.setIgnoreUnresolvablePlaceholders(true);
		return A;
	}
	
//WeatherUrlからセットしてくる
	@Bean
	public WeatherUrl weatherUrl() {
		
		WeatherUrl weatherUrl = new WeatherUrl();
		weatherUrl.setUrl(url);
		weatherUrl.setApiKey(apikey);
		return weatherUrl;
	}


}

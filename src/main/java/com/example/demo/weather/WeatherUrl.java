package com.example.demo.weather;

import lombok.Getter;
import lombok.Setter;

public class WeatherUrl {

	@Getter
	@Setter
	private String url;
	
	@Getter
	@Setter
	private String apiKey;
	
	public WeatherUrl() {
		super();
		// TODO Auto-generated constructor stub
	}
}

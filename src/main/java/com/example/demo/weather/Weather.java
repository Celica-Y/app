package com.example.demo.weather;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{
	@Getter
	@Setter
	private String weatherDescription; //天気のデータ
	
	@Getter
	@Setter
	private String name;
	
	@Bean
	public Weather weather() {
		return new Weather();
	}
	
	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
//		リストでJOSNを取得。
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherDescription((String) weather.get("description"));
	}
}


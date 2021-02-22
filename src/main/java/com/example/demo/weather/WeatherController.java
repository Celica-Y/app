package com.example.demo.weather;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ComponentScan("com.example.demo.weather.WeatherConfig")
@RestController
public class WeatherController {

	@Autowired
	RestTemplate restTemp;
	
	@Autowired
	private WeatherUrl weatherUrl;
	
	@RequestMapping(value = "/weather",method=RequestMethod.GET)
	public ModelAndView Get(ModelAndView mv) {
		mv.addObject("city", new FormCity());
		mv.setViewName("formData");
		return mv;
	}
	
	@RequestMapping(value = "/weather",method=RequestMethod.POST)
	public ModelAndView Post(ModelAndView mv, @ModelAttribute FormCity city) 
			throws JsonParseException, JsonMappingException, IOException{
		
		UriComponents uriComponents = UriComponentsBuilder
				.newInstance()
				.scheme("http")
				.host(weatherUrl.getUrl()) //urlの部分
			    .path("")
			    .query("q={keyword}&appid={appid}")
			    .buildAndExpand(city.getCity(),weatherUrl.getApiKey());  //受け取った都市名とapiKeyがはいる
		
		String uri = uriComponents.toUriString();
		
		ResponseEntity<String> resp= restTemp.exchange(uri, HttpMethod.GET, null, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		Weather weather = mapper.readValue(resp.getBody(), Weather.class);

		
		mv.addObject("weatherData", weather);
		mv.setViewName("WeatherDetails"); 
		return mv;
	}
}

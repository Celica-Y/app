package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
class AppApplicationTests {

	@Test
	public void urlを正しく作成しているかどうか() {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	      .scheme("http").host("api.openweathermap.org/data/2.5/weather")
	      .path("").query("q={keyword}&appid={appid}").buildAndExpand("Tokyo","ba79fe7533b670d70de082a8cef039f4");
	 
	     assertEquals("http://api.openweathermap.org/data/2.5/weather?q=Tokyo&appid=ba79fe7533b670d70de082a8cef039f4", uriComponents.toUriString());

	}

}

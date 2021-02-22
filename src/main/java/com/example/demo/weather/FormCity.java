package com.example.demo.weather;

import lombok.Getter;
import lombok.Setter;

public class FormCity {
//	町の名前の格納場所
	@Getter
	@Setter
	private String city;
	
	public FormCity(String city) {
		super();
		this.city = city;
	}

	public FormCity() {
		super();
	}
}

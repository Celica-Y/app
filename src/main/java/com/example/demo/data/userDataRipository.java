package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userDataRipository extends 
	JpaRepository<userData, Long>{

	public userData findByName(String name);
}

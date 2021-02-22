package com.example.demo.data;

import javax.persistence.*;


@Entity
@Table(name="userData2")
public class userData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private long id;
	
	@Column(name = "pass", length = 8, nullable = false)
	private String password;
	
	@Column(name = "userName", length = 20, nullable = false)
	private String name;
	
	 @Column(nullable = false)
	    private boolean enabled;
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public boolean isEnabled() {
		return this.enabled;
	}

	
	}
	

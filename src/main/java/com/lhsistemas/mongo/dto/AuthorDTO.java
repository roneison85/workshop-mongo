package com.lhsistemas.mongo.dto;

import java.io.Serializable;

import com.lhsistemas.mongo.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String email;
	
	public AuthorDTO() {}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

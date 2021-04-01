package com.vaescode.restservice.entity;

public class Saludo {

	public final Long id;

	public final String content;

	public Saludo(Long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	

}

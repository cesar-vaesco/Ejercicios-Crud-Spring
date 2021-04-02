package com.vaescode.webservice.tareas.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
@EnableScheduling
public class TareaProgramadaCntroller {

	
	@GetMapping
	public String hola() {
		
		return "Hola César";
	}
}

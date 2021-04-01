package com.vaescode.restservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.restservice.entity.Saludo;

@RestController
public class SaludoController {

	private static final String modelo = "Hola, %s!";
	private final AtomicLong contador = new AtomicLong();

	@GetMapping("/saludo")
	public Saludo saludos(@RequestParam(value = "nombre", defaultValue = "programador") String nombre) {

		return new Saludo(contador.incrementAndGet(), String.format(modelo, nombre));
	}

}

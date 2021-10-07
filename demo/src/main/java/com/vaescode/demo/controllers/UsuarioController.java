package com.vaescode.demo.controllers;

import com.vaescode.demo.models.Usuario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

	@RequestMapping(value = "usuario/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre("César");
		usuario.setApellido("Vargas");
		usuario.setEmail("cesar@correo.com");
		usuario.setTelefono("5568000916");
		usuario.setPassword("contrasenia");
		return usuario;
	}

	
	public Usuario listarUsuarios() {
		Usuario usuario = new Usuario();
		usuario.setNombre("César");
		usuario.setApellido("Vargas");
		usuario.setEmail("cesar@correo.com");
		usuario.setTelefono("5568000916");
		usuario.setPassword("contrasenia");
		return usuario;
	}

	
	public Usuario crearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("César");
		usuario.setApellido("Vargas");
		usuario.setEmail("cesar@correo.com");
		usuario.setTelefono("5568000916");
		usuario.setPassword("contrasenia");
		return usuario;
	}


	public Usuario editarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("César");
		usuario.setApellido("Vargas");
		usuario.setEmail("cesar@correo.com");
		usuario.setTelefono("5568000916");
		usuario.setPassword("contrasenia");
		return usuario;
	}


	public Usuario eliminarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("César");
		usuario.setApellido("Vargas");
		usuario.setEmail("cesar@correo.com");
		usuario.setTelefono("5568000916");
		usuario.setPassword("contrasenia");
		return usuario;
	}
}

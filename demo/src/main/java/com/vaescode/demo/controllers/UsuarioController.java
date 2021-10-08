package com.vaescode.demo.controllers;

import com.vaescode.demo.models.Usuario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

	@RequestMapping(value = "usuarios")
	public List<Usuario> listarUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNombre("César");
		usuario.setApellido("Vargas");
		usuario.setEmail("cesar@correo.com");
		usuario.setTelefono("5568000916");
		usuario.setPassword("contrasenia");
		
		Usuario usuario1 = new Usuario();
		usuario1.setId(2L);
		usuario1.setNombre("Vero");
		usuario1.setApellido("Cortez");
		usuario1.setEmail("vero@correo.com");
		usuario1.setTelefono("5556847216");
		usuario1.setPassword("contrasenia");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(3L);
		usuario2.setNombre("Vane");
		usuario2.setApellido("Vargas");
		usuario2.setEmail("vane@correo.com");
		usuario2.setTelefono("5553967841");
		usuario2.setPassword("contrasenia");
		
		
		usuarios.add(usuario);
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		return usuarios ;
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

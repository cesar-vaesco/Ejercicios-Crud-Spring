package com.vaescode.usuario.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.usuario.models.entity.Cliente;
import com.vaescode.usuario.models.service.IClienteService;

@RestController
@RequestMapping("/api/cliente")
public class UsuarioController {

	@Autowired
	private IClienteService clienteService;

	/** http://localhost:8080/api/cliente/listar */
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		return clienteService.findAll();
	}

	/** http://localhost:8080/api/usuario/listar/{id} */
	@GetMapping("/listar/{id}")
	public Optional<Cliente> listarPorId(@PathVariable Long id) {
		return Optional.ofNullable(clienteService.findById(id));
	}

	
	/* http://localhost:8080/api/cliente/crear */
	@PostMapping("/crear")
	public void crearCliente(@Validated @RequestBody Cliente cliente) {
		clienteService.saveCliente(cliente);
	}

	
	@PutMapping("/actualizar/{id}")
	public void actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {

		Optional<Cliente> encontrarCliente = Optional.ofNullable(clienteService.findById(id));
		
		if(encontrarCliente.isPresent()) {
			Cliente actualizarCliente = encontrarCliente.get();
			actualizarCliente.setId(cliente.getId());
			actualizarCliente.setNombre(cliente.getNombre());
			
			 clienteService.saveCliente(actualizarCliente);
		}
		
	}



	/* http://localhost:8080/api/cliente/borrar/{id} */
	@DeleteMapping("/borrar/{id}")
	public void borrarCliente(@PathVariable Long id) {

		clienteService.delete(id);
	}

}

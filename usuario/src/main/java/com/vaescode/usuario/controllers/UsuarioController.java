package com.vaescode.usuario.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api/clientes")
public class UsuarioController {

	@Autowired
	private IClienteService clienteService;
	
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);


	
	/** http://localhost:8080/api/clientes/listar */
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarCliente(){
		List<Cliente> clientes = clienteService.findAll();
		log.info("Clientes: " + clientes);
		return ResponseEntity.ok(clientes);
	}
	

	/** http://localhost:8080/api/usuario/listar/{id} */
	@GetMapping("/listar/{id}")
	public ResponseEntity<Cliente> listarClientes(@PathVariable Long id){
		
	
		Optional<Cliente> optionalCliente = Optional.ofNullable(clienteService.findById(id));
		if(optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}

	
	/* http://localhost:8080/api/cliente/crear */
	@PostMapping("/crear")
	public ResponseEntity<Cliente> crearCliente(@Validated @RequestBody Cliente cliente) {
	
		Cliente clienteNuevo =  clienteService.saveCliente(cliente);
		return ResponseEntity.ok(clienteNuevo);
	}

	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
		
		Optional<Cliente> encontrarCliente = Optional.ofNullable(clienteService.findById(cliente.getId()));
		
		if(encontrarCliente.isPresent()) {
			Cliente actualizarCliente = encontrarCliente.get();
			actualizarCliente.setId(cliente.getId());
			actualizarCliente.setNombre(cliente.getNombre());
			clienteService.saveCliente(actualizarCliente);
			return ResponseEntity.ok(actualizarCliente);
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	

	/* http://localhost:8080/api/cliente/borrar/{id} */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<Cliente> borrarCliente(@PathVariable Long id){
		
		Optional<Cliente> borrarCliente = Optional.ofNullable(clienteService.findById(id));
		if(borrarCliente.isPresent()) {
			clienteService.delete(id);
			log.info("Registro " + id + " eliminado!!! ");
			return ResponseEntity.ok(null);
		}
		log.info("Registro " + id + " no encontrado!!! ");
		return ResponseEntity.noContent().build();
	}

}

package com.vaescode.usuario.models.service;

import java.util.List;


import com.vaescode.usuario.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente saveCliente (Cliente cliente);
	
	public void delete (Long id);
}

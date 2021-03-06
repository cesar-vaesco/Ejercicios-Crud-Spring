package com.vaescode.producto.service;

import java.util.List;

import com.vaescode.producto.entity.Producto;

public interface IProductoService {
	
	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void delete (Long id);
	
	public Producto findByNombreandMarca(String nombre, String marca);
	
	//findByNombreandMarca(nombre, marca)

}

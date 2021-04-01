package com.vaescode.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaescode.producto.dao.ProductoRepository;
import com.vaescode.producto.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	public ProductoRepository productoRepository; 

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByNombreandMarca(String nombre, String marca) {
		return productoRepository.findByNombreandMarca(nombre, marca);
	}

}

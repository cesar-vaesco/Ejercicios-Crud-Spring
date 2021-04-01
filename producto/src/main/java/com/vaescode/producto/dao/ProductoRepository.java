package com.vaescode.producto.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vaescode.producto.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

	
	
	//@Query("select u from Usuario u where u.email = :email and u.password = :password")
    //@Query("SELECT c FROM Cliente c WHERE c.nombre= :alias AND c.cliente_id= :id")
	//<@Query("select p from Producto p where p.nombre = :nombre and p.marca = :marca")
	@Query("select p from Producto p where p.nombre = ?1 and p.marca = ?1")
	Producto findByNombreandMarca(@Param("nombre") String nombre, @Param("marca") String marca);
}

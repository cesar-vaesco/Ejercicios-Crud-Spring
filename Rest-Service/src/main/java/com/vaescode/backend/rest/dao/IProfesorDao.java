package com.vaescode.backend.rest.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vaescode.backend.rest.entity.Profesor;

public interface IProfesorDao extends CrudRepository<Profesor, Long> {
	
	
	public Profesor findByEmail(String email);

	public Profesor findByEmailAndPassword(String email, String password);
	
	public Optional<Profesor> findById(Long id);
}

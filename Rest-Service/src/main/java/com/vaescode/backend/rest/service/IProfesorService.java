package com.vaescode.backend.rest.service;

import java.util.List;
import java.util.Optional;

import com.vaescode.backend.rest.entity.Profesor;

public interface IProfesorService {

	public List<Profesor> findAll();
	
	public Profesor findProfesor(Profesor profesor);
	
	public Profesor checkPofesorLogin(Profesor profesor);
	
	public void deleteprofesor(Profesor profesor);
	
	public Profesor updateProfesor(Profesor profesor);
	
	public Optional<Profesor> findProfesorById(Profesor profesor_id);
	
	public void deleteProfesor(Long id);
	
	public Profesor findById(Long id);
	
	public Profesor findByIdSQL(Long id);
}

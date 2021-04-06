package com.vaescode.backend.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaescode.backend.rest.dao.IProfesorDao;
import com.vaescode.backend.rest.entity.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	public IProfesorDao profesorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findProfesor(Profesor profesor) {
		return (Profesor) profesorDao.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor checkPofesorLogin(Profesor profesor) {
		return (Profesor) profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional
	public void deleteprofesor(Profesor profesor) {
		profesorDao.delete(profesor);
	}

	@Override
	@Transactional
	public Profesor updateProfesor(Profesor profesor) {
		return (Profesor) profesorDao.save(profesor);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Optional<Profesor> findProfesorById(Long profesor_id) {
		return (Optional<Profesor>)profesorDao.findById(profesor_id);
	}

	@Override
	@Transactional
	public void deleteProfesor(Long id) {
		profesorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		return profesorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findByIdSQL(Long id) {
		return profesorDao.findByIdSQL(id);
	}

}

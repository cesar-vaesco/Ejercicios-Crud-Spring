package com.vaescode.backend.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.backend.rest.entity.Profesor;
import com.vaescode.backend.rest.mapper.ProfesorMapper;
import com.vaescode.backend.rest.model.MProfesor;
import com.vaescode.backend.rest.service.IProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorController {

	@Autowired
	private IProfesorService profesorService;

	/* http://localhost:8044/api/lista-profesores */
	@GetMapping("/lista-profesores")
	public ResponseEntity<List<Profesor>> listaprofesores() {

		List<Profesor> profesores = profesorService.findAll();

		if (profesores.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
		}
	}

	/* http://localhost:8044/api/profesores */
	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores() {
		return profesorService.findAll();
	}

	/* http://localhost:8044/api/get-profesor */
	/* Busqueda por correo y se regresan todos los datos del profesor*/
	@GetMapping("/get-profesor")
	public ResponseEntity<?> getProfesor(@RequestBody Profesor profesor) {

		Profesor profesordb = profesorService.findProfesor(profesor);

		if (profesordb != null) {
			return new ResponseEntity<>(profesordb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/profesor/{id}")
	public ResponseEntity<?> listarProfesorById(@PathVariable Long id) {

		Profesor profesor = profesorService.findById(id);

		if (profesor != null) {
			return new ResponseEntity<>(profesor, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	/* http://localhost:8044/api/registrar */
	@PostMapping("/registrar")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {

		if (profesorService.findProfesor(profesor) == null) {
			profesorService.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	/* http://localhost:8044/api/login */
	@PostMapping("/login")
	public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor){
		
		Profesor profesordb =profesorService.checkPofesorLogin(profesor);
		
		if(profesordb != null) {
			
			List<Profesor> profesores = new ArrayList<>();
			profesores.add(profesordb);
			
			List<MProfesor> mProfesores = new ArrayList<>();
			mProfesores = ProfesorMapper.convertirLista(profesores);
			
			return new ResponseEntity<>(mProfesores, HttpStatus.OK); 
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	/* http://localhost:8044/api/actualizar/{id} */
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> updateProfesor(@PathVariable("id") Long id, @RequestBody Profesor profesor) {

		Profesor profesordb = null;
		profesordb = profesorService.findById(id);
		if (profesordb != null) {
			profesordb.setNombre(profesor.getNombre());
			profesordb.setEmail(profesor.getEmail());
			profesorService.updateProfesor(profesordb);
			return new ResponseEntity<>(profesor, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	/* http://localhost:8044/api/eliminar/{id} */
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> deleteProfesor(@PathVariable("id") Long id) {

		Profesor profesordb = profesorService.findByIdSQL(id);

		if (profesordb == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {

			profesorService.deleteProfesor(id);

			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/eliminar-registros")
	public ResponseEntity<?> deleteProfesores() {

		List<Profesor> profesores = profesorService.findAll();

		if (profesores.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} else {

			profesorService.deleteAllProfesores();

			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}

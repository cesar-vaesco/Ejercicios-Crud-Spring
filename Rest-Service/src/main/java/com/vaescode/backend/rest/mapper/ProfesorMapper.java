package com.vaescode.backend.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaescode.backend.rest.entity.Profesor;
import com.vaescode.backend.rest.model.MProfesor;

@Component("mapper")
public class ProfesorMapper {
	
	public static List<MProfesor> convertirLista(List<Profesor> profesores){
		
		List<MProfesor> mProfesores = new ArrayList<>();
		
		for (Profesor profesor : profesores) {
			mProfesores.add(new MProfesor(profesor));
		}
		
		return mProfesores; 
	}

}

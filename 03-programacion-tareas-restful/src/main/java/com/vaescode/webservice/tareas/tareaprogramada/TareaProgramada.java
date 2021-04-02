package com.vaescode.webservice.tareas.tareaprogramada;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TareaProgramada {

	private static final Logger log = LoggerFactory.getLogger(TareaProgramada.class);

	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 50000)
	public void reportarHoraActual() {
		log.info("Hola César, la hora actual es {}", dateFormat.format(new Date()));
	}
}

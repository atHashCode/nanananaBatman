package com.atsistemas.hashcode.batmaaaaan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Carrera {
	private static final Logger LOGGER = LoggerFactory.getLogger(Carrera.class);
	Integer coordInicio[] = new Integer[2];
	Integer coordFin[] = new Integer[2];
	Integer inicio;
	Integer fin;

	public Carrera(Integer coordInicioRow, Integer coordInicioCol,Integer coordFinRow,Integer coordFinCol,Integer tiempoInicio,Integer Fin) {
		coordInicio[0] = coordInicioRow;
		coordInicio[1] = coordInicioCol;
		coordFin[0] = coordFinRow;
		coordFin[1] = coordFinCol;
		inicio = tiempoInicio;
		fin = tiempoFin;
	}

}
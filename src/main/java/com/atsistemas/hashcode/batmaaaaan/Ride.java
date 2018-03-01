package com.atsistemas.hashcode.batmaaaaan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ride {
	private static final Logger LOGGER = LoggerFactory.getLogger(Ride.class);
	Integer coordInicio[] = new Integer[2];
	Integer coordFin[] = new Integer[2];
	Integer inicio;
	Integer fin;

	public Ride(Integer coordInicioRow, Integer coordInicioCol,Integer coordFinRow,Integer coordFinCol,Integer tiempoInicio,Integer tiempoFin) {
		coordInicio[0] = coordInicioRow;
		coordInicio[1] = coordInicioCol;
		coordFin[0] = coordFinRow;
		coordFin[1] = coordFinCol;
		inicio = tiempoInicio;
		fin = tiempoFin;
	}

}
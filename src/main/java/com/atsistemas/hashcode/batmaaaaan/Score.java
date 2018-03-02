package com.atsistemas.hashcode.batmaaaaan;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Score {

	private static final Logger LOGGER = LoggerFactory.getLogger(Score.class);
	private List<Ride> carreras = new ArrayList<>();
	private Integer bonus;
	private Integer limit;

	public Score(List<Ride> carreras, Integer bonus, Integer limit) {
		this.carreras.addAll(carreras);
		this.bonus = bonus;
		this.limit = limit;
	}

	public Integer calculaScore(List<String> carrerasCoche) {
		Integer score = 0;
		Integer step = 0;
		Posicion ultimaPosicion = new Posicion(0,0);
		for (String posicion : carrerasCoche) {
			Ride carrera = carreras.get(Integer.parseInt(posicion));
			step += ultimaPosicion.calcularDistanciaDesde(carrera.getCoordInicio()); 
			Integer distancia = carrera.getDistancia();
			Integer inicio = carrera.getInicio();
			Integer fin = carrera.getFin();
			if (step + distancia < limit) {
				if (step + distancia <= fin) {
					score += distancia;
					if (step == inicio) {
						score += bonus;
					}
				}}
			ultimaPosicion = carrera.getCoordFin();
		}
		return score;
	}
}

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
			Ride ride = carreras.get(Integer.parseInt(posicion));
			calculaScore(ride, ultimaPosicion, step);
			step += ultimaPosicion.calcularDistanciaDesde(ride.getCoordInicio()); 
			score += calculaScore(ride, ultimaPosicion, step);
			ultimaPosicion = ride.getCoordFin();
		}
		return score;
	}
	public Integer calculaScore(Car car) {
		Integer score = 0;
		Integer step = 0;
		Posicion ultimaPosicion = new Posicion(0,0);
		List<Ride> carrerasCoche = car.getCarreras();
		if (!carrerasCoche.isEmpty()) {
			if (ultimaPosicion.calcularDistanciaDesde(carrerasCoche.get(0).getCoordInicio()) < carrerasCoche.get(0).getInicio()) {
				step = carrerasCoche.get(0).getInicio();
				ultimaPosicion = carrerasCoche.get(0).getCoordInicio();
			}
		}
		for (Ride ride : carrerasCoche) {
			step += ultimaPosicion.calcularDistanciaDesde(ride.getCoordInicio()); 
			score += calculaScore(ride, ultimaPosicion, step);
			ultimaPosicion = ride.getCoordFin();
		}
		return score;
	}
	public Integer calculaScore(Ride ride, Posicion from, Integer step) {
		Integer score = 0;
		Integer distancia = ride.getDistancia();
		Integer inicio = ride.getInicio();
		Integer fin = ride.getFin();

		
		if (step + distancia < limit) {
			if (step + distancia <= fin) {
				score += distancia;
				if (step == inicio) {
					score += bonus;
				}
			}
		}
		return score;
	}
}

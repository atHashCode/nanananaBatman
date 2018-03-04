package com.atsistemas.hashcode.batmaaaaan;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private List<Ride> carreras;
	Integer step;

	public Car() {
		super();
		this.carreras = new ArrayList<>();
		step = 0;
	}
	public Car(List<Ride> carreras) {
		super();
		this.carreras = carreras;
		Posicion ultimaPosicion = new Posicion(0,0);
		step = 0;
		for(Ride carrera: carreras) {
			step += ultimaPosicion.calcularDistanciaDesde(carrera.getCoordInicio());
			step += carrera.getDistancia();
			ultimaPosicion = carrera.getCoordFin();
		}
	}

	public void addCarrera(Ride carrera) {

		step += getUltimaPosicion().calcularDistanciaDesde(carrera.getCoordInicio());
		if (carreras.isEmpty()) {
			if (getUltimaPosicion().calcularDistanciaDesde(carrera.getCoordInicio()) < carrera.getInicio()) {
				step = carrera.getInicio();
			}
		}
		
		step += carrera.getDistancia();
		carreras.add(carrera);
	}
	public List<Ride> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Ride> carreras) {
		this.carreras = carreras;
	}
	
	public Integer getUltimoStep() {
		return step;
	}
	
	public Posicion getUltimaPosicion() {
		Posicion ultimaPosicion = new Posicion(0,0);
		if (!carreras.isEmpty()) {
			ultimaPosicion = carreras.get(carreras.size() - 1).getCoordFin();
		}
		return ultimaPosicion;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder(10);
		string.append("Ultima Posicion ").append(getUltimaPosicion()).append("**");
		string.append("Ultimo paso ").append(getUltimoStep()).append("**");
		string.append("Carreras ").append(carreras);
		
		return string.toString();
	}
	
}

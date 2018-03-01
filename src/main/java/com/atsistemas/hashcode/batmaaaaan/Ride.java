package com.atsistemas.hashcode.batmaaaaan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ride {
	private static final Logger LOGGER = LoggerFactory.getLogger(Ride.class);
	private Posicion coordInicio;
	private Posicion coordFin;
	private Integer inicio;
	private Integer fin;
	private Integer distancia;

	public Ride(Integer coordInicioRow, Integer coordInicioCol,Integer coordFinRow,Integer coordFinCol,Integer tiempoInicio,Integer tiempoFin) {
		coordInicio = new Posicion(coordInicioRow,coordInicioCol);;
		coordFin = new Posicion(coordFinRow,coordFinCol);
		inicio = tiempoInicio;
		fin = tiempoFin;
		distancia = coordInicio.calcularDistanciaDesde(coordFin);
	}

	/**
	 * @return the coordInicio
	 */
	public Posicion getCoordInicio() {
		return coordInicio;
	}

	/**
	 * @param coordInicio the coordInicio to set
	 */
	public void setCoordInicio(Posicion coordInicio) {
		this.coordInicio = coordInicio;
	}

	/**
	 * @return the coordFin
	 */
	public Posicion getCoordFin() {
		return coordFin;
	}

	/**
	 * @param coordFin the coordFin to set
	 */
	public void setCoordFin(Posicion coordFin) {
		this.coordFin = coordFin;
	}

	/**
	 * @return the inicio
	 */
	public Integer getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fin
	 */
	public Integer getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(Integer fin) {
		this.fin = fin;
	}

	/**
	 * @return the distancia
	 */
	public Integer getDistancia() {
		return distancia;
	}

	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

}
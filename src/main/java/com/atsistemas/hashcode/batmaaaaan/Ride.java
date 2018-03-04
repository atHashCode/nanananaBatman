package com.atsistemas.hashcode.batmaaaaan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ride {
	private static final Logger LOGGER = LoggerFactory.getLogger(Ride.class);
	private Integer indice;
	private Posicion coordInicio;
	private Posicion coordFin;
	private Integer inicio;
	private Integer fin;
	private Integer distancia;

	public Ride(Integer indice, Integer coordInicioRow, Integer coordInicioCol,Integer coordFinRow,Integer coordFinCol,Integer tiempoInicio,Integer tiempoFin) {
		this.indice = indice;
		coordInicio = new Posicion(coordInicioRow,coordInicioCol);
		coordFin = new Posicion(coordFinRow,coordFinCol);
		inicio = tiempoInicio;
		fin = tiempoFin;
		distancia = coordInicio.calcularDistanciaDesde(coordFin);
	}

	public Integer distanciaACarrera(Ride ride) {
		return distancia;
	}
	public Integer distanciaACarrera(Posicion desde) {
		return this.getCoordFin().calcularDistanciaDesde(desde);
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

	/**
	 * @return the indice
	 */
	public Integer getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(Integer indice) {
		this.indice = indice;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(").append(indice).append(" ").append(this.coordInicio).append("->").append(this.coordFin).append("<").append(this.inicio).append(":").append(this.fin).append(">").append(this.distancia);
		return builder.toString();
	}

}
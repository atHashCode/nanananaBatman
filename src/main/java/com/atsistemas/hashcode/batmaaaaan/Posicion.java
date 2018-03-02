package com.atsistemas.hashcode.batmaaaaan;

public class Posicion {

	private int x;
	private int y;

	public Posicion(int x, int y) {
		this.x=x;
		this.y=y;
	}

	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int calcularDistanciaDesde(Posicion parametros) {
		int cateto1 = this.x - parametros.getX();
		int cateto2 = this.y - parametros.getY();
		return Math.abs(cateto1) + Math.abs(cateto2);
	}

}

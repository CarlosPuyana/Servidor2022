package org.iesalixar.servidor.cpp.model;

import java.io.Serializable;

public class Reserva implements Serializable {

	private String fInicio, fFin, servicios;
	private int numPer;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public String getfInicio() {
		return fInicio;
	}

	public void setfInicio(String fInicio) {
		this.fInicio = fInicio;
	}

	public String getfFin() {
		return fFin;
	}

	public void setfFin(String fFin) {
		this.fFin = fFin;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public int getNumPer() {
		return numPer;
	}

	public void setNumPer(int numPer) {
		this.numPer = numPer;
	}
	
	 
	
	
	
	
}

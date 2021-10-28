package org.iesalixar.servidor.cpp.model;

import java.io.Serializable;

public class Reserva implements Serializable {

	private String fInicio, fFin;
	private String[] servicios;
	private String numPer;
	
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

	public String[] getServicios() {
		return servicios;
	}

	public void setServicios(String[] strings) {
		this.servicios = strings;
	}

	public String getNumPer() {
		return numPer;
	}

	public void setNumPer(String numPer) {
		this.numPer = numPer;
	}
	
	 
	
	
	
	
}

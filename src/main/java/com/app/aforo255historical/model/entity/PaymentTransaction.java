package com.app.aforo255historical.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "paymenttransaction")
public class PaymentTransaction {

	private String id;
	private int nroprestamo;
	private double importe_couta;
	private int couta;
	private int prestamoid;
	private String type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNroprestamo() {
		return nroprestamo;
	}
	public void setNroprestamo(int nroprestamo) {
		this.nroprestamo = nroprestamo;
	}
	public double getImporte_couta() {
		return importe_couta;
	}
	public void setImporte_couta(double importe_couta) {
		this.importe_couta = importe_couta;
	}
	public int getCouta() {
		return couta;
	}
	public void setCouta(int couta) {
		this.couta = couta;
	}
	public int getPrestamoid() {
		return prestamoid;
	}
	public void setPrestamoid(int prestamoid) {
		this.prestamoid = prestamoid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}

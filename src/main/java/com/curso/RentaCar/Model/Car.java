package com.curso.RentaCar.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Integer idCar;
	private String brandCar;
	private String modelCar;
	
	
	public Integer getIdCar() {
		return idCar;
	}
	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}
	public String getBrandCar() {
		return brandCar;
	}
	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}
	public String getModelCar() {
		return modelCar;
	}
	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}
	@Override
	public String toString() {
		return "Car [idCar=" + idCar + ", brandCar=" + brandCar + ", modelCar=" + modelCar + "]";
	}
	public Car(Integer idCar, String brandCar, String modelCar) {
		super();
		this.idCar = idCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
	}
	public Car() {
		super();
		
	}
	
	
}

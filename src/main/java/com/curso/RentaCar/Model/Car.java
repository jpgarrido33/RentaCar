package com.curso.RentaCar.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Integer idCar;
	private String brandCar;
	private String modelCar;
	
	@OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
	private List<Rent> rents = new ArrayList<Rent>();
	
	public List<Rent> getRents() {
		return rents;
	}
	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
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

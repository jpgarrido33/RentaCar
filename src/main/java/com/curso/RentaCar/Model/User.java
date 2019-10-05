package com.curso.RentaCar.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User {
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Integer idUser;
	private String name;
	
	public Integer getIdCar() {
		return idUser;
	}
	public void setIdCar(Integer idCar) {
		this.idUser = idCar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Car [idCar=" + idUser + ", name=" + name + "]";
	}
	public User(Integer idUser, String name) {
		super();
		this.idUser = idUser;
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

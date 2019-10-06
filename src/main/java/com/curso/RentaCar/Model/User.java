package com.curso.RentaCar.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Integer idUser;
	private String name;
	

	@OneToMany//(mappedBy = "user")
	private List<Rent> rents =new ArrayList<Rent>();
	
//	@OneToMany(mappedBy = "user")
//	private List<Car> car =new ArrayList<Car>();

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

//	public List<Car> getCar() {
//		return car;
//	}
//
//	public void setCar(List<Car> car) {
//		this.car = car;
//	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", rents=" + rents + "]";
	}

	public User(Integer idUser, String name, List<Rent> rents, List<Car> car) {
		
		this.idUser = idUser;
		this.name = name;
		this.rents = rents;
		//this.car = car;
	}

	public User() {
	}
	
	}
	
	

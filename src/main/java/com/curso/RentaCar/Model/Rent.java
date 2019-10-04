package com.curso.RentaCar.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Integer idRent;
	private LocalDate initDate;
	private LocalDate finalDate;
	private User user;
	private Car car;
	public Integer getIdRent() {
		return idRent;
	}
	public void setIdRent(Integer idRent) {
		this.idRent = idRent;
	}
	public LocalDate getInitDate() {
		return initDate;
	}
	public void setInitDate(LocalDate initDate) {
		this.initDate = initDate;
	}
	public LocalDate getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Rent [idRent=" + idRent + ", initDate=" + initDate + ", finalDate=" + finalDate + ", user=" + user
				+ ", car=" + car + "]";
	}
	public Rent(Integer idRent, LocalDate initDate, LocalDate finalDate, User user, Car car) {
		super();
		this.idRent = idRent;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.user = user;
		this.car = car;
	}
	public Rent() {
		super();
		
	}
	
	
	
}

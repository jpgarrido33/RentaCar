package com.curso.RentaCar.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Integer idRent;
	private LocalDate initDate;
	private LocalDate finalDate;
	private Double price;
	private User user;
	private Car car;
	
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATETIME")
	private Date dateCreatedRent;
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
	
	public Rent(Integer idRent, LocalDate initDate, LocalDate finalDate, Double price, User user, Car car) {
		super();
		this.idRent = idRent;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.price = price;
		this.user = user;
		this.car = car;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public Date getDateCreatedRent() {
		return dateCreatedRent;
	}
	public void setDateCreatedRent(Date dateCreatedRent) {
		this.dateCreatedRent = dateCreatedRent;
	}
	public Rent() {
		super();
		
	}
	
	
	
}

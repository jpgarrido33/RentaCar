package com.curso.RentaCar.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Model.User;

@Component
public class RentDto {

	private Integer idRent;
	@NotNull(message ="El Valor no puede ser Nulo")
	@NotBlank(message = "Debe especificar una fecha: yyyy/mm/aa")
	private String initDate;
	@NotNull(message ="El Valor no puede ser Nulo")
	@NotBlank(message = "Debe especificar una fecha: yyyy/mm/aa")
	private String finalDate;
	@NotNull(message ="El Valor no puede ser Nulo")
	@NotBlank(message = "Debe asignar un usuario")
	private User user;
	@NotNull(message ="El Valor no puede ser Nulo")
	@NotBlank(message = "Debe asignar un coche")
	private Car car;
	@NotNull(message ="El Valor no puede ser Nulo")
	@NotBlank(message = "Debe asignar un precio")
	private double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getIdRent() {
		return idRent;
	}
	public void setIdRent(Integer idRent) {
		this.idRent = idRent;
	}
	public String getInitDate() {
		return initDate;
	}
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	public String getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(String finalDate) {
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
	
	
	

	public RentDto(Integer idRent,
			@NotNull(message = "El Valor no puede ser Nulo") @NotBlank(message = "Debe especificar una fecha: yyyy/mm/aa") String initDate,
			@NotNull(message = "El Valor no puede ser Nulo") @NotBlank(message = "Debe especificar una fecha: yyyy/mm/aa") String finalDate,
			@NotNull(message = "El Valor no puede ser Nulo") @NotBlank(message = "Debe asignar un usuario") User user,
			@NotNull(message = "El Valor no puede ser Nulo") @NotBlank(message = "Debe asignar un coche") Car car,
			@NotNull(message = "El Valor no puede ser Nulo") @NotBlank(message = "Debe asignar un precio") double price) {
		super();
		this.idRent = idRent;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.user = user;
		this.car = car;
		this.price = price;
	}
	
	public RentDto() {
		super();
		
	}
}

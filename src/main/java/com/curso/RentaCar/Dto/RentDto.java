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
	private UserDto userDto;
	@NotNull(message ="El Valor no puede ser Nulo")
	@NotBlank(message = "Debe asignar un coche")
	private CarDto carDto;
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

	
	

	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public CarDto getCarDto() {
		return carDto;
	}
	public void setCarDto(CarDto carDto) {
		this.carDto = carDto;
	}
	
	
	
	public RentDto() {
		super();
		
	}
}

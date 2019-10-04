package com.curso.RentaCar.Dto;
import org.springframework.stereotype.Component;

@Component
public class UserDto {

	
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
	public UserDto(Integer idUser, String name) {
		super();
		this.idUser = idUser;
		this.name = name;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}

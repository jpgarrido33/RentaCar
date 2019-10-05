package com.curso.RentaCar.Dto;
import org.springframework.stereotype.Component;

@Component
public class UserDto {

	
	private Integer idUser;
	private String name;
	
	
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
	@Override
	public String toString() {
		return "UserDto [idUser=" + idUser + ", name=" + name + "]";
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
	
package com.curso.RentaCar.Dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

	
	private Integer idUser;
	@NotNull(message ="El nombre de usuario no puede tener un valor nulo")
	@NotBlank(message = "Debe especificar un nombre de usuario")
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
	
	
	public UserDto(Integer idUser,
			@NotNull(message = "El nombre de usuario no puede tener un valor nulo") @NotBlank(message = "Debe especificar un nombre de usuario") String name) {
		super();
		this.idUser = idUser;
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserDto [idUser=" + idUser + ", name=" + name + "]";
	}
	public UserDto() {
		super();
		
	}
	
}
	
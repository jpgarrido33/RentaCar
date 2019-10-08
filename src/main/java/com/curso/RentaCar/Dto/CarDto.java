package com.curso.RentaCar.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class CarDto {
	private Integer idCar;
	
	@NotNull(message ="La marca coche no puede ser Nulo")
	@NotBlank(message = "La marca de coche deber ser cumplimentado")
	private String brandCar;
	@NotNull(message ="El modelo de coche no puede ser Nulo")
	@NotBlank(message = "El modelo de coche deber ser cumplimentado")
	private String modelCar;
	
	
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
	
	public CarDto(Integer idCar,
			@NotNull(message = "La marca coche no puede ser Nulo") @NotBlank(message = "La marca de coche deber ser cumplimentado") String brandCar,
			@NotNull(message = "El modelo de coche no puede ser Nulo") @NotBlank(message = "El modelo de coche deber ser cumplimentado") String modelCar) {
		super();
		this.idCar = idCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
	}
	
	public CarDto() {
		super();
		
	}

}

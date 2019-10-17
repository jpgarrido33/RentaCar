package com.curso.RentaCar.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class CarDtoProfit {

	private Integer idCar;
	
	private String brandCar;

	private String modelCar;
	
	private double profit;

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

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "CarDtoProfit [idCar=" + idCar + ", brandCar=" + brandCar + ", modelCar=" + modelCar + ", profit="
				+ profit + "]";
	}

	public CarDtoProfit(Integer idCar, String brandCar, String modelCar, double profit) {
		super();
		this.idCar = idCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.profit = profit;
	}

	public CarDtoProfit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

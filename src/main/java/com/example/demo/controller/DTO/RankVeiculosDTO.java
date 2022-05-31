package com.example.demo.controller.DTO;


import lombok.Data;

@Data
public class RankVeiculosDTO {

	
	private String NomeVeiculo;
	private String modeloVeiculo;
	private String MarcaVeiculo;
	private Integer Ano;
	private String gastoDentroCidade;
	private String gastoDentroRodovia;
	private Double gastoTotal;
}

package com.example.demo.models;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="VEICULO")

public class VeiculosVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private int id;
	@Column(name = "NOME", nullable=false)
	private String nome;
	@Column(name = "MARCA", nullable=false)
	private String marca;
	@Column(name = "MODELO", nullable=false)
	private String modelo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="DATAFABRICACAO", nullable=false)
	private LocalDate dataFabricao;
	@Column(name="CMKMCIDADE", nullable=false)
	private Double consumoMedioKmDentroCidade;
	@Column(name="CMKMRODOVIA", nullable=false)
	private Double consumoMedioKmRodovias;
}

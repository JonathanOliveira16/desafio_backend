package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.controller.DTO.CalculoDTO;
import com.example.demo.controller.DTO.RankVeiculosDTO;
import com.example.demo.services.VeiculoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v2/calculo")
@Slf4j
public class CalculoConsumoController {

	@Autowired
	private VeiculoService veicService;
	
	@GetMapping("/lista")
	public List<RankVeiculosDTO> getPrevisaoGastos(@RequestBody CalculoDTO dadosCalculo){
		try {
			return veicService.getListaVeiculos(dadosCalculo);
		} catch (Exception e) {
			log.error("error", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno na aplicação");
		}
		
	}
}

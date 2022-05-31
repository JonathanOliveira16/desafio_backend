package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.DTO.ResponseStatusMessage;
import com.example.demo.models.VeiculosVO;
import com.example.demo.services.VeiculoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v2/cadastro")
@Slf4j
public class CadastroVeiculoController {

	@Autowired
	private VeiculoService veicService;
	
	@PostMapping("/veiculo")
	public ResponseStatusMessage insertVaiculo(@RequestBody VeiculosVO veiculo){
		try {
			return veicService.insertVeiculo(veiculo);
		} catch (Exception e) {
			log.error("error", e);
			return new ResponseStatusMessage("Falha interna no sistema, verifique os campos enviados!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

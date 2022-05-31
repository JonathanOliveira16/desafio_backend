package com.example.demo.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.controller.DTO.CalculoDTO;
import com.example.demo.controller.DTO.RankVeiculosDTO;
import com.example.demo.controller.DTO.ResponseStatusMessage;
import com.example.demo.models.VeiculosVO;
import com.example.demo.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veicRepo;
	DecimalFormat df = new DecimalFormat("#.##");
	
	public ResponseStatusMessage insertVeiculo(VeiculosVO veiculo) {
		if(veiculo != null) {
			veicRepo.save(veiculo);
			return new ResponseStatusMessage("Registro inserido com sucesso!", HttpStatus.CREATED);
		}else {
			return new ResponseStatusMessage("Falha ao salvar registro.", HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<RankVeiculosDTO> getListaVeiculos(CalculoDTO calc){
		List<VeiculosVO> listaVeiculos = veicRepo.findAll();
		return calculoCombustivel(listaVeiculos, calc);
	}
	
	private List<RankVeiculosDTO> calculoCombustivel(List<VeiculosVO> listaVeiculos, CalculoDTO calc) {
		List<RankVeiculosDTO> listaDeRanks = new ArrayList<RankVeiculosDTO>();
		listaVeiculos.stream().forEach((x)->{
			RankVeiculosDTO rank = new RankVeiculosDTO();
			rank.setGastoDentroCidade(df.format((calc.getGasolinaPreco() / x.getConsumoMedioKmDentroCidade()) * calc.getTotalKmRodadoCidade()));
			rank.setGastoDentroRodovia(df.format((calc.getGasolinaPreco() / x.getConsumoMedioKmRodovias()) * calc.getTotalKmRodadoRodovia()));
			rank.setGastoTotal(Double.parseDouble(rank.getGastoDentroCidade().replace(',', '.')) + Double.parseDouble(rank.getGastoDentroRodovia().replace(',', '.')));
			rank.setAno(x.getDataFabricao().getYear());
			rank.setNomeVeiculo(x.getNome());
			rank.setMarcaVeiculo(x.getMarca());
			rank.setModeloVeiculo(x.getModelo());
			listaDeRanks.add(rank);
		});
		return listaDeRanks.stream()
		  .sorted(Comparator.comparing(RankVeiculosDTO::getGastoTotal))
		  .collect(Collectors.toList());
	}
	
	
}

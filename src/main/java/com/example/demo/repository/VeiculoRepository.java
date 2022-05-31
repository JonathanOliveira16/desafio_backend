package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.VeiculosVO;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculosVO, Integer> {
	
}

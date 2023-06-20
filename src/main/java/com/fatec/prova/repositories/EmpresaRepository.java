package com.fatec.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.prova.entities.Empresa;

public interface EmpresaRepository extends JpaRepository <Empresa, Integer>{
    
}

package com.edson.desafio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edson.desafio.model.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}

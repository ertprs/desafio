package com.edson.desafio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edson.desafio.model.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

}

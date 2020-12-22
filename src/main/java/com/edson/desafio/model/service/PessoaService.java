package com.edson.desafio.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.desafio.model.entity.Pessoa;
import com.edson.desafio.model.repository.PessoaRepository;
import com.edson.desafio.model.util.AbstractService;

@Service
public class PessoaService extends AbstractService<Pessoa> {

	@Autowired
	public PessoaService(PessoaRepository repository) {
		super(repository);
	}

}

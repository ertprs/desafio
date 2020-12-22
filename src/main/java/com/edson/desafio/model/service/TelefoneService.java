package com.edson.desafio.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.desafio.model.entity.Telefone;
import com.edson.desafio.model.repository.TelefoneRepository;
import com.edson.desafio.model.util.AbstractService;

@Service
public class TelefoneService extends AbstractService<Telefone> {

	@Autowired
	public TelefoneService(TelefoneRepository repository) {
		super(repository);
	}

}

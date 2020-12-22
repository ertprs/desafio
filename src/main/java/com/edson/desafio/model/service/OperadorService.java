package com.edson.desafio.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.desafio.model.entity.Operador;
import com.edson.desafio.model.entity.Usuario;
import com.edson.desafio.model.repository.OperadorRepository;
import com.edson.desafio.model.util.AbstractService;
import com.edson.desafio.model.util.Encrypt;

@Service
public class OperadorService extends AbstractService<Operador> {

	@Autowired
	public OperadorService(OperadorRepository operadorRepository) {
		super(operadorRepository);
	}

	@Override
	protected void onInsert(Operador obj) throws Exception {
		obj.getUsuario().setSenha(Encrypt.encrypt(obj.getUsuario().getSenha()));
	}
	
}
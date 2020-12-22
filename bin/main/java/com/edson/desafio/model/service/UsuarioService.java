package com.edson.desafio.model.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.desafio.model.entity.Operador;
import com.edson.desafio.model.entity.Usuario;
import com.edson.desafio.model.repository.OperadorRepository;
import com.edson.desafio.model.repository.UsuarioRepository;
import com.edson.desafio.model.util.AbstractService;
import com.edson.desafio.model.util.Encrypt;

@Service
public class UsuarioService extends AbstractService<Usuario> {

	private UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Operador login(Usuario usuario) {
		try {
			usuario.setSenha(Encrypt.encrypt(usuario.getSenha()));
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		return repository.login(usuario.getLogin(), usuario.getSenha());
	}
	
}
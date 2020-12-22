package com.edson.desafio.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edson.desafio.model.entity.Operador;
import com.edson.desafio.model.entity.Usuario;
import com.edson.desafio.model.service.UsuarioService;
import com.edson.desafio.model.util.AbstractController;
import com.edson.desafio.model.util.JwtUtil;

@RestController
@RequestMapping(value = "/login")
public class UsuarioController extends AbstractController<Usuario> {

	private UsuarioService service;

	@Autowired
	public UsuarioController(UsuarioService service) {
		super(service);
		this.service = service;
	}

	@RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Operador> login(@RequestBody Usuario usuario) {
		Operador result = service.login(usuario);
		if (result == null) {
			throw new ServiceException("Usuário e/ou Senha inválido(s)!");
		}
		result.getUsuario().setToken(JwtUtil.encode(result.getUsuario().getLogin()));
		return new ResponseEntity<Operador>(result, HttpStatus.ACCEPTED);
	}

}

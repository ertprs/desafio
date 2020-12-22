package com.edson.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edson.desafio.model.entity.Operador;
import com.edson.desafio.model.service.OperadorService;
import com.edson.desafio.model.util.AbstractController;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorController extends AbstractController<Operador> {

	@Autowired
	public OperadorController(OperadorService service) {
		super(service);
	}

}

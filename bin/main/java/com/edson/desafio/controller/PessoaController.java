package com.edson.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edson.desafio.model.entity.Pessoa;
import com.edson.desafio.model.service.PessoaService;
import com.edson.desafio.model.util.AbstractController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController extends AbstractController<Pessoa> {

	@Autowired
	public PessoaController(PessoaService service) {
		super(service);
	}

}

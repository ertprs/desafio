package com.edson.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edson.desafio.model.entity.Telefone;
import com.edson.desafio.model.service.TelefoneService;
import com.edson.desafio.model.util.AbstractController;

@RestController
@RequestMapping(value = "/telefones")
public class TelefoneController extends AbstractController<Telefone> {

	@Autowired
	public TelefoneController(TelefoneService service) {
		super(service);
	}

}

package com.edson.desafio.model.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractController<T extends BaseEntity> {

	private AbstractService<T> service;

	public AbstractController(AbstractService<T> service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> loadAll() throws Exception {
		List<T> result = service.findAll();
		return new ResponseEntity<List<T>>(result, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> load(@PathVariable Integer id) throws Exception {
		T result = service.findOne(id);
		return new ResponseEntity<T>(result, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> insert(@RequestBody T obj) throws Exception {
		T result = service.save(obj);
		return new ResponseEntity<T>(result, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> update(@RequestBody T obj) throws Exception {
		T result = service.update(obj);
		return new ResponseEntity<T>(result, HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", consumes = MediaType.ALL_VALUE)
	public ResponseEntity<T> delete(@PathVariable Integer id) throws Exception {
		service.delete(id);
		return new ResponseEntity<T>(HttpStatus.OK);
	}

}

package com.edson.desafio.model.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<T extends BaseEntity> {

	private JpaRepository<T, Integer> repository;

	public AbstractService(JpaRepository<T, Integer> repository) {
		this.repository = repository;
	}

	public T save(T obj) throws Exception {
		validateInsert(obj);
		validate(obj);
		onInsert(obj);
		return repository.save(obj);
	}

	public List<T> saveAll(List<T> operadores) throws Exception {
		return repository.saveAll(operadores);
	}

	public T update(T obj) throws Exception {
		validateUpdate(obj);
		validate(obj);
		onUpdate(obj);
		return repository.save(obj);
	}

	public List<T> findAll() throws Exception {
		return repository.findAll();
	}

	public T findOne(Integer id) throws Exception {
		return repository.findById(id).get();
	}

	public void delete(Integer id) throws Exception {
		onDelete(findOne(id));
		repository.deleteById(id);
	}

	public JpaRepository<T, Integer> getRepository() {
		return repository;
	}

	protected void onInsert(T obj) throws Exception {
	}

	protected void onUpdate(T obj) throws Exception {

	}

	protected void onDelete(T obj) throws Exception {

	}

	protected void validate(T obj) throws Exception {

	}

	protected void validateInsert(T obj) throws Exception {

	}

	protected void validateUpdate(T obj) throws Exception {

	}

}

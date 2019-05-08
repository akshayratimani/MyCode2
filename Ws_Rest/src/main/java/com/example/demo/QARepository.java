package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QARepository extends CrudRepository<QA, Long> {
	
	
	public List<QA> findByQuestion(String question);
	
	public List<QA> findTop3ByCategory(String category);

}


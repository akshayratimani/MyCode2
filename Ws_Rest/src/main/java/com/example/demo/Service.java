package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	QARepository obj;

	public Iterable<QA> getAnswer(String question) {
		return obj.findByQuestion(question);
	}

	
	public Iterable<QA> getRelatedQuestions(String category) {
		return obj.findTop3ByCategory(category);
	}

	public Iterable<QA> getAnswerByCat(String cat) {
		if (cat.equals("all")) {
			return obj.findAll();
		}
		return obj.findTop3ByCategory(cat);
	}

	public void setQa(QA data) {
		obj.save(data);
	}
}

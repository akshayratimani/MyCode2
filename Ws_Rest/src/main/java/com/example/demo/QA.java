package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String question;
	private String answer;
	private String category;
	
	public QA() {
	}

	public QA(int id, String question, String answer, String category) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.category = category;
	}
	
	

	public QA(String question, String answer, String category) {
		super();
		this.question = question;
		this.answer = answer;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "QA [id=" + id + ", question=" + question + ", answer=" + answer + ", category=" + category + "]";
	}
	


}

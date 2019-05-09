package com.example.demo;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import abc.QA;

@Component
public class QARepository {

	private static final Map<String, QA> QARep = new HashMap<>();

	@Autowired
	JdbcTemplate jdbc;

	@PostConstruct
	public void initData() {

		QA q = new QA();

		q.setQuestion("What is JAVA");
		q.setAnswer("OOPS");
		q.setType("Tech");

		QARep.put(q.getQuestion(), q);

		q.setQuestion("Who is Virat Kohli");
		q.setAnswer("Indian Cricket team Captain");
		q.setType("General");

		QARep.put(q.getQuestion(), q);

	}

	public QA getAnswer(String question) {
		System.out.println("DAta:" + QARep.get(question));
		
		return QARep.get(question);
	}

	@Transactional(readOnly = true)
	public QA getAnswerJdbc(String question) {

		return jdbc.queryForObject("select * from QA where question=?", new Object[] { question }, new QARowMapper());

	}

	@Transactional(readOnly = true)
	public List<QA> getDataJdbc(String cat) {

		if (cat.equals("")) {
			return jdbc.query("select * from QA", new QARowMapper());
		} else if (cat.equalsIgnoreCase("tech") || cat.equalsIgnoreCase("busin") || cat.equalsIgnoreCase("func")) {

			return jdbc.query("select * from QA where category=?", new Object[] { cat }, new QARowMapper());

		}

		ArrayList a = new ArrayList<QA>();
		a.add(new QA("", "", "Category not avaliable"));

		return a;


	}

	public String setDataJdbc(List<QA> li) {

		String pos = "Inserted sucessfully";

		System.out.println("Size:" + li.size());

		for (QA a : li) {

			QA temp = null;
			try {
				temp = jdbc.queryForObject("select * from QA where question=?", new Object[] { a.getQuestion() },
						new QARowMapper());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("TempData:" + temp);
			if (temp == null) {
				jdbc.update("insert into QA(answer,category,question) values(?,?,?)",
						new Object[] { a.getAnswer(), a.getType(), a.getQuestion() });
				return "Inserted Successfully";
			} else {
				return "Question already exists";
			}

		}

		return "";
	}
}
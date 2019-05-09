package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import abc.QA;

public class QARowMapper implements RowMapper<QA> {

	@Override
	public QA mapRow(ResultSet rs, int rowNum) throws SQLException {
		QA obj = new QA();
		
		obj.setQuestion(rs.getString("question"));
		obj.setAnswer(rs.getString("answer"));
		obj.setType(rs.getString("category"));
		obj.setId(rs.getInt("id"));
		
		return obj;
	}

}

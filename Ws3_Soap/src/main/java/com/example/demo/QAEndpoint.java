package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import abc.GetAnswerRequest;
import abc.GetAnswerResponse;
import abc.GetDataRequest;
import abc.GetDataResponse;
import abc.QA;
import abc.SetDataRequest;
import abc.SetDataResponse;

@Endpoint
public class QAEndpoint {
	private static final String NAMESPACE_URI = "abc";

	private QARepository StudentRepository;

	@Autowired
	public QAEndpoint(QARepository StudentRepository) {
		this.StudentRepository = StudentRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswerRequest")
	@ResponsePayload
	public GetAnswerResponse getAnswer(@RequestPayload GetAnswerRequest request) {
		GetAnswerResponse response = new GetAnswerResponse();
		response.setQA(StudentRepository.getAnswerJdbc(request.getQuestion()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDataRequest")
	@ResponsePayload
	public GetDataResponse getQA(@RequestPayload GetDataRequest request) {
		GetDataResponse response = new GetDataResponse();
		String cat = request.getCategory();

		response.getQA().addAll(StudentRepository.getDataJdbc(request.getCategory()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setDataRequest")
	@ResponsePayload
	public SetDataResponse setQA(@RequestPayload SetDataRequest request) {
		SetDataResponse response = new SetDataResponse();

		response.setMessage(StudentRepository.setDataJdbc(request.getQA()));

		return response;

	}
}
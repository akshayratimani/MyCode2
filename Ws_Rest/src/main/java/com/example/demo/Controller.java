package com.example.demo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping("/poc")
public class Controller {

	@Autowired
	QARepository a;

	@Autowired
	Service s;

	// Dummy Method .
	@GetMapping("/{id}")
	public String getHelloWorld(@PathVariable String id) {
		return "HelloWorld"+id;
	}

	// Dummy method to add QA to the DB.
	@GetMapping("/send")
	public void postQuestion() {
		QA obj = new QA(122,
				"Name the software company which becomes World's Third Company with the one trillion dollars.",
				"Microsoft	", "buss");

		a.save(obj);
	}

	// Method which takes question as input and returns Question , Answer along with
	// the Type.
	@GetMapping(value = "/getAnswer", produces = "application/json")
	public String getAnswer(@RequestParam Map<String, String> m) throws JSONException {

		String cat = null;

		// Checking if there is no Questions as Input
		if (m.size() == 0) {
			return "Please send Question";
		}

		JSONObject j = new JSONObject();

		List l = new ArrayList<>();
		List<String> questions = new ArrayList<>();
		String q = null;

		// Iterating the input(Question(s)) and constructing a list of appropriate
		// results.
		for (Map.Entry<String, String> entry : m.entrySet()) {
			String question = entry.getValue();

			Iterable<QA> data = s.getAnswer(question);
			for (QA ab : data) {
				cat = ab.getCategory();
				l.add(ab);
			}
		}

		// Constructing the list with Related questions
		Iterable<QA> rel = s.getRelatedQuestions(cat);

		for (QA ab : rel) {
			q = ab.getQuestion();
			questions.add(q);
		}

		// Constructing json object
		j.put("QA", l);
		j.put("Related Questions", questions);
		String b = j.toString();

		System.out.println("JSON data:" + b);

		return b;

	}

	//Method to Get QA By Category
	@GetMapping(value = "/getAnswerByCat")
	public List<Object> getAnswerByCat(@RequestParam(required = false) String cat) {
		try {
			if (cat.equalsIgnoreCase("technical") || cat.equalsIgnoreCase("tech")) {
				cat = "tech";
			} else if (cat.equalsIgnoreCase("busniess") || cat.equalsIgnoreCase("buss")) {
				cat = "buss";
			} else if (cat.equalsIgnoreCase("functional") || cat.equalsIgnoreCase("func")) {
				cat = "func";
			} else {
				List<Object> a = new ArrayList<>();
				a.add("Invalid Caegory");
				return a;
			}
		} catch (NullPointerException e) {
			List<Object> a = new ArrayList<>();
			a.add("Category not Found");
			return a;
		}
		return (List) s.getAnswerByCat(cat);

	}

	// Method which implements posting of Question Answer and Category type.
	@PostMapping(value = "/setQA", produces = "application/json")
	public String setQA(@RequestBody(required = false) String a) throws JSONException {

		JSONObject j = new JSONObject();
		List<QA> q;
		Type listType = new TypeToken<List<QA>>() {
		}.getType();
		q = new Gson().fromJson(a, listType);

		try {
			System.out.println("Data:" + q.size());
		} catch (NullPointerException e) {
			j.put("Message", "Empty Input");
			return j.toString();
		}

		for (QA t : q) {

			if (t.getAnswer() == null || t.getQuestion() == null || t.getCategory() == null) {
				System.out.println("NULL");
			} else {
				s.setQa(t);
			}

		}

		return "true";

	}

}

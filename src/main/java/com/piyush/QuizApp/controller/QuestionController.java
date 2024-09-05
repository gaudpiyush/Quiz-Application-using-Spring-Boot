package com.piyush.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piyush.QuizApp.model.Question;
import com.piyush.QuizApp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	QuestionService questionService;
	
	@Autowired
	QuestionController(QuestionService service) {
		super();
		this.questionService = service;
	}
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return questionService.getAllQuestionsByCategory(category);
	}

	@PostMapping ("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question){
		return questionService.addQuestion(question);
	}

}

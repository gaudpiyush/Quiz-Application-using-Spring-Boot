package com.piyush.QuizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piyush.QuizApp.model.Question;
import com.piyush.QuizApp.repo.QuestionRepo;

@Service
public class QuestionService {

	QuestionRepo questionRepo;
	
	@Autowired
	public QuestionService(QuestionRepo repo) {
		super();
		this.questionRepo = repo;
	}

	public ResponseEntity<List<Question>> getAllQuestions() {
		return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
		return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
	}


	public ResponseEntity<String> addQuestion(Question question) {
		questionRepo.save(question);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}
}

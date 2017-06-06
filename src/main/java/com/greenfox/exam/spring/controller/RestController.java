package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.Service.QuestionService;
import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionSet;
import com.greenfox.exam.spring.repository.QuestionRepo;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Nóra on 2017. 06. 06..
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
  
  @Autowired
  QuestionRepo repo;

  @GetMapping("/questions")
  public QuestionSet giveQuestions() {
    ArrayList<Question> questions = new ArrayList<>(repo.findTop5ByOrderById());
    QuestionSet questionSet = new QuestionSet(1, questions);
    return questionSet;
  }


}

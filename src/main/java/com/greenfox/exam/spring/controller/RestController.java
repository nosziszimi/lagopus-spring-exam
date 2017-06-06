package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.Answer;
import com.greenfox.exam.spring.model.AnswerSet;
import com.greenfox.exam.spring.model.ProjectList;
import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionSet;
import com.greenfox.exam.spring.repository.AnswerRepo;
import com.greenfox.exam.spring.repository.QuestionRepo;
import com.greenfox.exam.spring.repository.QuestionSetRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Nóra on 2017. 06. 06..
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  QuestionRepo questionRepo;

  @Autowired
  QuestionSetRepo setRepo;

  @Autowired
  AnswerRepo answerRepo;

  @GetMapping("/questions")
  public QuestionSet giveQuestions() {
    ArrayList<Question> questions = new ArrayList<>(questionRepo.findTop5ByOrderById());
    QuestionSet questionSet = new QuestionSet(0, questions);
    //setRepo.save(questionSet);
    return questionSet;
  }

  @PostMapping("/answers")
  public ProjectList receiveAnswers(@RequestBody AnswerSet answerSet) {
    List<Answer> answers = answerSet.getAnswers();
    int counter = 0;
    for (int i = 0; i < 5; i++) {
      Answer actualAnswer = answers.get(i);
      long id = actualAnswer.getId();
      Answer correctAnswer = answerRepo.findById(id);
      if (actualAnswer.getAnswer().equals(correctAnswer.getAnswer())) {
        counter ++;
      }
    }
    if (counter == 5) {
      return new ProjectList("correct");
    }
    return new ProjectList();
  }


}

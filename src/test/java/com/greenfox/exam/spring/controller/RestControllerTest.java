package com.greenfox.exam.spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.greenfox.exam.spring.ExamApplication;
import com.greenfox.exam.spring.model.Answer;
import com.greenfox.exam.spring.model.AnswerSet;
import com.greenfox.exam.spring.model.ProjectList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


/**
 * Created by Nóra on 2017. 06. 06..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExamApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class RestControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void giveQuestions() throws Exception {
    mockMvc.perform(get("/questions"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", is(0)));
  }

  @Test
  public void receiveAnswersWithWrongAnswer() throws Exception {
    AnswerSet answerSet = new AnswerSet();
    answerSet.setId(0L);
    List<Answer> answers = new ArrayList<>();
    for (int i = 0; i < 5 ; i++) {
      answers.add(new Answer(i,""));
    }
    answerSet.setAnswers(answers);

    mockMvc.perform(post("/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answerSet)))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(new ProjectList());
  }
}

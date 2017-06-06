package com.greenfox.exam.spring;

import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

  @Autowired
  QuestionRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Question(0, "When did your course start?"));
		repo.save(new Question(0, "What is HerrNorbert's favourite color?"));
		repo.save(new Question(0, "How many classes are learning at Green Fox Academy at this moment? "));
		repo.save(new Question(0, "How many mentors teach at Green Fox at this moment?"));
		repo.save(new Question(0, "What was the name of the first Green Fox class?"));
		repo.save(new Question(0, "How many likes do we have on facebook?"));
		repo.save(new Question(0, "What is Tojas's horoscope?"));
		repo.save(new Question(0, "What is the color code of Green Fox?"));
		repo.save(new Question(0, "When was Green Fox founded?(yyyy.mm.)"));

	}
}

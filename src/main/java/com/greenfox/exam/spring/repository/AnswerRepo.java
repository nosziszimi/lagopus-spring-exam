package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nóra on 2017. 06. 06..
 */
public interface AnswerRepo extends CrudRepository<Answer, Long>{

  public Answer findById(long id);

}

package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.QuestionSet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nóra on 2017. 06. 06..
 */

public interface QuestionSetRepo extends CrudRepository<QuestionSet, Long>{

  public QuestionSet findById(long id);

}

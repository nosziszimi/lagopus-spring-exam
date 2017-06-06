package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nóra on 2017. 06. 06..
 */

public interface QuestionRepo extends CrudRepository<Question, Long> {

}

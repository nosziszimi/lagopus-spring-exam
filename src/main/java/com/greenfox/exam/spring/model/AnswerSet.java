package com.greenfox.exam.spring.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Nóra on 2017. 06. 06..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AnswerSet {

  long id;
  List<Answer> answers;

}

package com.greenfox.exam.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Nóra on 2017. 06. 06..
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class QuestionSet implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  ArrayList<Question> questions;

}

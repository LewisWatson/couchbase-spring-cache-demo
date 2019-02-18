package com.github.lewiswatson.couchbase.spring.cache.demo.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Dog implements Serializable {

  private static final long serialVersionUID = -2320063941577184748L;

  String name;
  String breed;

}

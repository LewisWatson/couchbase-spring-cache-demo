package com.github.lewiswatson.couchbase.spring.cache.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CouchbaseSpringCacheDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CouchbaseSpringCacheDemoApplication.class, args);
  }

}


package com.github.lewiswatson.couchbase.spring.cache.demo.service;

import com.github.lewiswatson.couchbase.spring.cache.demo.model.Dog;

public interface DogCache {

  Dog put(Object key, Dog dog);

}

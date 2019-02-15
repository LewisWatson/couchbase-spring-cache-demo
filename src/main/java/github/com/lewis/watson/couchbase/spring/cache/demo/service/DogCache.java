package github.com.lewis.watson.couchbase.spring.cache.demo.service;

import github.com.lewis.watson.couchbase.spring.cache.demo.model.Dog;

public interface DogCache {

  Dog put(Object key, Dog dog);

}

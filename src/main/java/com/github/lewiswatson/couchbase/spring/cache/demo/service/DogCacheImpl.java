package com.github.lewiswatson.couchbase.spring.cache.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import com.github.lewiswatson.couchbase.spring.cache.demo.model.Dog;

@Component
public class DogCacheImpl implements DogCache {

  @Autowired
  private DogCacheProperties properties;

  @Autowired
  private CacheManager cacheManager;

  @Override
  public Dog put(Object key, Dog dog) {
    cacheManager.getCache(properties.getName()).put(key, dog);
    return dog;
  }

}

package github.com.lewis.watson.couchbase.spring.cache.demo.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@ConfigurationProperties(prefix = "demo")
@Data
public class DogServiceProperties {

  private CacheProperties cache;
  
  @Data
  public static class CacheProperties {
    private String name;
    private int timeToLiveSeconds;
  }
  
}
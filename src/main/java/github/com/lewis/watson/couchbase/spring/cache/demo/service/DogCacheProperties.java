package github.com.lewis.watson.couchbase.spring.cache.demo.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@ConfigurationProperties(prefix = "dog-cache", ignoreInvalidFields = false,
    ignoreUnknownFields = false)
@Data
public class DogCacheProperties {

  private String name;
  private int timeToLiveSeconds;

}

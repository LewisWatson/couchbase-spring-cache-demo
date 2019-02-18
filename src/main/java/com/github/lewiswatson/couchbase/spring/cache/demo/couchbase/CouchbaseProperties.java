package com.github.lewiswatson.couchbase.spring.cache.demo.couchbase;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import lombok.Data;

@Component
@ConfigurationProperties(prefix = "spring.couchbase")
@Data
@Validated
public class CouchbaseProperties {

  /**
   * The list of hostnames (or IP addresses) to bootstrap from.
   */
  private List<String> bootstrapHosts;

  private Bucket bucket;

  @Data
  public static class Bucket {

    /**
     * The name of the bucket to connect to.
     */
    private String name;

    /**
     * The user of the bucket
     */
    private String username;

    /**
     * The password of the bucket
     */
    private String password;
  }

}

package github.com.lewis.watson.couchbase.spring.cache.demo.couchbase;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.spring.cache.CacheBuilder;
import com.couchbase.client.spring.cache.CouchbaseCacheManager;
import github.com.lewis.watson.couchbase.spring.cache.demo.service.DogCacheProperties;

@Configuration
public class CouchbaseCacheConfig {

  @Bean(destroyMethod = "disconnect")
  public Cluster cluster(CouchbaseProperties properties) {
    return CouchbaseCluster.create(properties.getBootstrapHosts())
        .authenticate(properties.getBucket().getUsername(), properties.getBucket().getPassword());
  }

  @Bean(destroyMethod = "close")
  public Bucket bucket(Cluster cluster, CouchbaseProperties properties) {
    return cluster.openBucket(properties.getBucket().getName());
  }

  @Bean
  public CacheManagerCustomizer<CouchbaseCacheManager> cacheManagerCustomizer(Bucket bucket,
      DogCacheProperties properties) {
    return c -> c.prepareCache(properties.getName(),
        CacheBuilder.newInstance(bucket).withExpiration(properties.getTimeToLiveSeconds()));
  }
}

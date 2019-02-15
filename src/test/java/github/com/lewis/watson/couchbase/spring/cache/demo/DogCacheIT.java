package github.com.lewis.watson.couchbase.spring.cache.demo;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import java.util.concurrent.Callable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import github.com.lewis.watson.couchbase.spring.cache.demo.model.Dog;
import github.com.lewis.watson.couchbase.spring.cache.demo.service.DogCache;
import github.com.lewis.watson.couchbase.spring.cache.demo.service.DogCacheProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DogCacheIT {

  @Autowired
  private DogCache dogService;

  @Autowired
  private DogCacheProperties properties;

  @Autowired
  private CacheManager cacheManager;

  @Test
  public void givenAKeyValuePairWhenPersistedToCacheThenValueShouldBeRetrievableByTheKeyUntilTheConfiguredTTLExpires() {

    /*
     * Given
     */

    String givenKey = "bonnie-dog";
    final Dog givenValue = Dog.builder().name("Bonnie").breed("English Springer Spaniel").build();

    /*
     * When
     */

    dogService.put(givenKey, givenValue);

    /*
     * Then
     */

    Cache cache = cacheManager.getCache(properties.getName());

    assertThat(cache.get(givenKey, Dog.class))
        .as(String.format("cache should contain expected value for key: %s", givenKey))
        .isEqualTo(givenValue);

    await().atMost(properties.getTimeToLiveSeconds() + 1l, SECONDS)
        .until(keyNoLongerExistsInCache(cache, givenKey));

  }

  private Callable<Boolean> keyNoLongerExistsInCache(Cache cache, String key) {
    return () -> cache.get(key) == null;
  }

}

package com.practice.mtcs.controllers;

import com.practice.mtcs.cache.RedisBackedCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
public class RedisBackedCacheIntTest {

    private RedisBackedCache underTest;

    // container {
    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
        .withExposedPorts(6379);

    // }

    @BeforeEach
    public void setUp() {
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();
        Jedis jedis = new Jedis(redis.getHost(), redis.getMappedPort(6379));

        // Now we have an address and port for Redis, no matter where it is running
        underTest = new RedisBackedCache(jedis, "test");
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.put("test", "example");

        Optional<String> retrieved = underTest.get("test", String.class);
        assertThat(retrieved.get()).isEqualTo("example");
    }
}

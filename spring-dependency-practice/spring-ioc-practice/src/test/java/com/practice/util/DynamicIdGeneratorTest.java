package com.practice.util;

import com.practice.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes={AppConfig.class})
@ExtendWith(SpringExtension.class)
public class DynamicIdGeneratorTest {

    @Autowired
    DynamicIdGenerator generator;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testId() {
        Assertions.assertNotNull(applicationContext);
        System.out.println(applicationContext.getClass().getSimpleName());
        Assertions.assertNotNull(generator);
        String uniqueId = generator.generateUniqueId();
        Assertions.assertNotNull(uniqueId);
    }
}

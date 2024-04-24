package com.practice.sequence;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Primary
public class DatePrefixGenerator implements PrefixGenerator {


    public DatePrefixGenerator(String dateFormat) {

    }

    @Override
    public String generatePrefix() {
        return UUID.randomUUID().toString().substring(0,8);
    }
}
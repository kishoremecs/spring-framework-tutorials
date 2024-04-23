package com.practice.sequence;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
public class DatePrefixGenerator implements PrefixGenerator {

    public DatePrefixGenerator(String dateFormat) {

    }
}
package com.practice.config;

import com.practice.sequence.DatePrefixGenerator;
import com.practice.sequence.PrefixGenerator;
import com.practice.sequence.Sequence;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {
                                "com.practice.sequence.*Dao",
                                "com.practice.sequence.*Service"})},
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {org.springframework.stereotype.Controller.class})})
@Import(PrefixConfiguration.class)
public class SequenceConfiguration {
  @Bean
  public Sequence sequence() {
    var seqgen = new Sequence("IT", "30", "A");

    seqgen.setInitial(100000);
    return seqgen;
  }

  @Bean
  public DatePrefixGenerator datePrefixGenerator() {
    return new DatePrefixGenerator("yyyyMMdd");
  }
  @Bean
  public Sequence sequenceGenerator(ObjectProvider<PrefixGenerator> prefixGenerator) {
    var generator = new Sequence("A", "KI", "MM");
    generator.setPrefixGenerator(prefixGenerator);
    return generator;
  }
}
package com.practice.sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Sequence {

  @Autowired
  private List<PrefixGenerator> prefixGenerators;

  private PrefixGenerator prefixGenerator;
//  private Map<String, PrefixGenerator> prefixGenerators;
//  private PrefixGenerator[] prefixGenerators;

  private final String id;
  private final String prefix;
  private final String suffix;


  public Sequence(String id, String prefix, String suffix) {
    this.id = id;
    this.prefix = prefix;
    this.suffix = suffix;
  }
  public String getId() {
    return id;
  }
  public String getPrefix() {
    return prefix;
  }
  public String getSuffix() {
    return suffix;
  }

  private final AtomicInteger counter = new AtomicInteger();

  public void setInitial(int initial) {
    this.counter.set(initial);
  }
  public String nextValue() {
    return prefix + counter.getAndIncrement() + suffix;
  }

  @Autowired
  public void setPrefixGenerator(ObjectProvider<PrefixGenerator> prefixGeneratorProvider) {
    this.prefixGenerator = prefixGeneratorProvider.getIfUnique();
  }

  public PrefixGenerator getPrefixGenerator() {
    return this.prefixGenerator;
  }

}
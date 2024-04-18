package com.practice.sequence;
import java.util.concurrent.atomic.AtomicInteger;
public class Sequence {

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
}
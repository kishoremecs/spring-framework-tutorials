package com.practice.sequence;

public interface SequenceDao {
  Sequence getSequence(String sequenceId);
  int getNextValue(String sequenceId);
}
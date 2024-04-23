package com.practice.sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SequenceService {

  private SequenceDao sequenceDao;

  @Autowired
  public SequenceService(SequenceDao sequenceDao) {
    this.sequenceDao=sequenceDao;
  }

  public String generate(String sequenceId) {
    var sequence = sequenceDao.getSequence(sequenceId);
    var value = sequenceDao.getNextValue(sequenceId);
    return sequence.getPrefix() + value + sequence.getSuffix();
  }
}
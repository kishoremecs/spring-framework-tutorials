package com.practice.sequence;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;

public class PrefixGeneratorObjectProvider implements ObjectProvider<PrefixGenerator> {

    @Override
    public PrefixGenerator getObject(Object... args) throws BeansException {
        return null;
    }

    @Override
    public PrefixGenerator getIfAvailable() throws BeansException {
        return null;
    }

    @Override
    public PrefixGenerator getIfUnique() throws BeansException {
        return null;
    }

    @Override
    public PrefixGenerator getObject() throws BeansException {
        return null;
    }
}

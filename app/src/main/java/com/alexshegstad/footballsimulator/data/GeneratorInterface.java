package com.alexshegstad.footballsimulator.data;

import java.util.List;

public interface GeneratorInterface<T> {
    T generate();
    List<T> generateBatch(int count);
    void setSeed(long seed);
}

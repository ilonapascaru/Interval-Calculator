package ness.service;

import ness.beans.Input;
import ness.beans.Output;

import java.util.Collection;
import java.util.List;

public interface IntervalService {
    public List<Output> getOutputIntervals(List<Input> inputs);
    public Collection<Input> getIntervals();
    public abstract Input getInterval(int id);
    public abstract void updateInterval(int id, Input input);
    public abstract void deleteProduct(int id);
}

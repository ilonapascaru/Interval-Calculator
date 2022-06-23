package ness.service;

import ness.beans.Input;
import ness.beans.Output;
import ness.utilities.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class IntervalServiceImpl implements IntervalService {

    private static  Map<Integer, Input> inputRepo= new HashMap<>();
    public Utils utils;
    static{
        Input input1 = new Input();
        input1.setId(0);
        input1.setStart("24/06/2014 08:22:07");
        input1.setEnd("28/12/2016 12:10:14");
        inputRepo.put(input1.getId(),input1);

        Input input2 = new Input();
        input2.setId(1);
        input2.setStart("15/08/2014 15:38:55");
        input2.setEnd("18/12/2019 08:34:26");
        inputRepo.put(input2.getId(),input2);

        Input input3 = new Input();
        input3.setId(2);
        input3.setStart("06/06/2015 04:12:34");
        input3.setEnd("12/05/2018 08:56:34");
        inputRepo.put(input3.getId(),input3);

    }

    @Override
    public List<Output> getOutputIntervals(List<Input> inputs) {
        List<Output> outputs = new ArrayList<Output>();

        for ( int i=0; i<inputs.size(); i++ ) {
            Output output = new Output();
            if ( i>=1 ) {
                output.setBreakTime(utils.getIntervalDuration(inputs.get(i-1).getEnd(),inputs.get(i).getStart()));
            }
            output.setDuration(utils.getIntervalDuration(inputs.get(i).getStart(),inputs.get(i).getEnd()));
            output.setStart(inputs.get(i).getStart());
            output.setEnd(inputs.get(i).getEnd());
            output.setId(inputs.get(i).getId());
            outputs.add(output);
        }

        return outputs;
    }

    @Override
    public Collection<Input> getIntervals() {
        return inputRepo.values();
    }

    @Override
    public Input getInterval(int id) {
            return inputRepo.get(id);
    }

    @Override
    public void updateInterval(int id, Input input) {
        inputRepo.remove(id);
        input.setId(id);
        inputRepo.put(id,input);

    }

    @Override
    public void deleteProduct(int id) {
        inputRepo.remove(id);
    }
}

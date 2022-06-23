package ness.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Output extends Input{

    String duration;


    String breakTime;

    public Output() {
    }

    public Output(String duration, String breakTime) {
        this.duration = duration;
        this.breakTime = breakTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getBreakTime() {
        return breakTime;
    }

    @JsonProperty("break")
    public void setBreakTime(String breakTime) {
        this.breakTime = breakTime;
    }

    public Output(int id, String start, String end, String duration, String breakTime) {
        super(id, start, end);
        this.duration = duration;
        this.breakTime = breakTime;

    }

    @Override
    public String toString() {
        return "Output{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", duration='" + duration + '\'' +
                ", break='" + breakTime + '\'' +
                '}';
    }
}

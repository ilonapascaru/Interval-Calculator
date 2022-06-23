package ness.beans;

import java.time.LocalDateTime;

public class Input {

    int id;
    String start;
    String end;

    public Input() {
    }

    public Input(int id, String start, String end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Input{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

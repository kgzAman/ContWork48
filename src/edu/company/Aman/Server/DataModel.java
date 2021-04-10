package edu.company.Aman.Server;


import java.util.ArrayList;
import java.util.List;

public class DataModel {
    private List<Day> days = new ArrayList<>();

    public DataModel() {
        for (int i = 1; i <31 ; i++) {
        this.days.add(new Day(i));

        }
    }

    public List<Day> getDay() {
        return days;
    }

    public void setDay(List<Day> day) {
        this.days = day;
    }
}

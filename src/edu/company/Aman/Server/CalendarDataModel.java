package edu.company.Aman.Server;


import edu.company.Aman.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalendarDataModel {
    private List<Task> tasks;
    private List<Day> days = getDays();
    static List<Day> dayList;

    public CalendarDataModel() {

    }
    public static Day findByDay(int a) {
        Day day = new Day(-1);
        for (Day d : dayList) {
            if (d.getNumber() == a) {
                day = d;
                break;
            }
        }
        return day;
    }
    public List<Day> getDays() {
        return days;
    }
    public CalendarDataModel(List<Day> days) {
        this.days = days;
    }

}

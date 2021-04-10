package edu.company.Aman.Server;


import edu.company.Aman.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataModel {
    private List<Task> tasks;
    private List<Day> days = new ArrayList<>();
    private Category category;

    public DataModel() {
        for (int i = 1; i <32 ; i++) {
            Day day = new Day(i,makeTasks());
        this.days.add(day);
        }
    }

    public List<Task> makeTasks(){
        List<Task> tasksForDay = new ArrayList<>();

        Random ran = new Random();
        int numberOfTasks = ran.nextInt(6) + 1;
        for(int i = 0; i < numberOfTasks; i++) {

            Task task = new Task(Generator.makeName(),Generator.makeDescription());
            tasksForDay.add(task);
        }
        return tasksForDay;
    }

    public List<Day> getDay() {
        return days;
    }

    public void setDay(List<Day> day) {
        this.days = day;
    }
}

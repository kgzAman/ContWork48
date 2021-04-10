package edu.company.Aman.Server;

import java.util.ArrayList;
import java.util.List;

public class Day {
    private int number;
    private List<Task> tasks = new ArrayList<>();

    public Day(int number ) {
        this.number=number;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }



}

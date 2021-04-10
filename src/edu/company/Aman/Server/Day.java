package edu.company.Aman.Server;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Day {
    private int number;
    private List<Task> tasks = new ArrayList<>();

    public Day(int number, List<Task> tasks) {
        this.number = number;
        Random r = new Random();
        int a = r.nextInt(5)+1;

        this.tasks.add(new Task());
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

//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }


}

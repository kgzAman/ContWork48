package edu.company.Aman.Server;

import edu.company.Aman.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Day {
    private int number;
    private List<Task> tasks= new ArrayList<>();

    public Day(int number) {
        this.number = number;
            this.tasks.add(new Task());
            this.tasks.add(new Task());
            this.tasks.add(new Task());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    static class Task{
        private Category category;
        private String description;

        public Task() {
            Random random= new Random();
            int ran = random.nextInt(1)+3;
            switch (ran) {
                case 1 -> this.category = Category.SHOPPING;
                case 2 -> this.category = Category.WORK;
                case 3 -> this.category = Category.ORDINARY;
            }
                this.description = Generator.makeDescription();
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "category=" + category +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Day{" +
                "number=" + number +
                ", tasks=" + tasks +
                '}';
    }
}

package edu.company.Aman.Server;


public class Task {
    private String name;
    private String img;
    private String description;
    private Category event;

    public Task(String name, String img, String description, Category event) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getEvent() {
        return event;
    }

    public void setEvent(Category event) {
        this.event = event;
    }
}

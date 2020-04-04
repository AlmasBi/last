package com.example.lab6;

public class ExampleItem {
    public int id;
    public String title;
    public String description;
    public String status;
    public String category;
    public String duration;


    public ExampleItem(int id,String title,String description,String status, String category,String duration){
        this.id=id;
        this.title=title;
        this.description=description;
        this.status=status;
        this.category=category;
        this.duration=duration;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public String getCategory() {
        return category;
    }
    public String getDuration() {
        return duration;
    }
}

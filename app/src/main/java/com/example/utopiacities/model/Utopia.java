package com.example.utopiacities.model;

public class Utopia{
    String Id;
    String Name;
    String SubTitles;
    String Number;

    public  Utopia(){

    }

    public Utopia(String name, String sub, String number,String id) {
        this.Id = id;
        this.Name = name;
        this.SubTitles = sub;
        this.Number = number;
    }

    public  Utopia(String Name,String SubTitles,String Number){
        this.Name = Name;
        this.SubTitles = SubTitles;
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubTitles() {
        return SubTitles;
    }

    public void setSubTitles(String subTitles) {
        SubTitles = subTitles;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}

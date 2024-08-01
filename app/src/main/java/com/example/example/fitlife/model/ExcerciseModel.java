package com.example.example.fitlife.model;

public class ExcerciseModel {

    String image;
    String name;
    int cal;
    String setCount;

    public ExcerciseModel(String image, String name, int cal,String setCount) {
        this.image = image;
        this.name = name;
        this.cal = cal;
        this.setCount = setCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public String getSetCount() {
        return setCount;
    }

    public void setSetCount(String setCount) {
        this.setCount = setCount;
    }
}

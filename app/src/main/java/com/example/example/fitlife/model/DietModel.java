package com.example.example.fitlife.model;

public class DietModel {

    String name;
    int cal;
    String breakfastPlan;
    String launchPlan;
    String dinnerPlan;

    public DietModel(String name, int cal, String breakfastPlan, String launchPlan, String dinnerPlan) {
        this.name = name;
        this.cal = cal;
        this.breakfastPlan = breakfastPlan;
        this.launchPlan = launchPlan;
        this.dinnerPlan = dinnerPlan;
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

    public String getBreakfastPlan() {
        return breakfastPlan;
    }

    public void setBreakfastPlan(String breakfastPlan) {
        this.breakfastPlan = breakfastPlan;
    }

    public String getLaunchPlan() {
        return launchPlan;
    }

    public void setLaunchPlan(String launchPlan) {
        this.launchPlan = launchPlan;
    }

    public String getDinnerPlan() {
        return dinnerPlan;
    }

    public void setDinnerPlan(String dinnerPlan) {
        this.dinnerPlan = dinnerPlan;
    }
}

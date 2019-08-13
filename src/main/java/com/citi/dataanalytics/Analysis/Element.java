package com.citi.dataanalytics.Analysis;

public class Element {
    private  float value;
    private  String date;

    public Element(float value, String date) {
        this.value = value;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                ", date='" + date + '\'' +
                '}';
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.citi.dataanalytics.Analysis;

import com.citi.dataanalytics.entity.Stock;

import java.util.ArrayList;

public class Analysis {
    String stock_name;

    Element high_price;
    Element low_price;
    float avg_price;

    Element high_up;
    Element  low_down;
    float avg_change;

    Element high_diff;
    Element low_diff;
    float avg_diff;

    Element high_volume;
    Element low_volume;
    float avg_volume;

    public Analysis(String stock_name, Element high_price, Element low_price, float avg_price, Element high_up, Element low_down, float avg_change, Element high_diff, Element low_diff, float avg_diff, Element high_volume, Element low_volume, float avg_volume) {
        this.stock_name = stock_name;
        this.high_price = high_price;
        this.low_price = low_price;
        this.avg_price = avg_price;
        this.high_up = high_up;
        this.low_down = low_down;
        this.avg_change = avg_change;
        this.high_diff = high_diff;
        this.low_diff = low_diff;
        this.avg_diff = avg_diff;
        this.high_volume = high_volume;
        this.low_volume = low_volume;
        this.avg_volume = avg_volume;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public Element getHigh_price() {
        return high_price;
    }

    public void setHigh_price(Element high_price) {
        this.high_price = high_price;
    }

    public Element getLow_price() {
        return low_price;
    }

    public void setLow_price(Element low_price) {
        this.low_price = low_price;
    }

    public float getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(float avg_price) {
        this.avg_price = avg_price;
    }

    public Element getHigh_up() {
        return high_up;
    }

    public void setHigh_up(Element high_up) {
        this.high_up = high_up;
    }

    public Element getLow_down() {
        return low_down;
    }

    public void setLow_down(Element low_down) {
        this.low_down = low_down;
    }

    public float getAvg_change() {
        return avg_change;
    }

    public void setAvg_change(float avg_change) {
        this.avg_change = avg_change;
    }

    public Element getHigh_diff() {
        return high_diff;
    }

    public void setHigh_diff(Element high_diff) {
        this.high_diff = high_diff;
    }

    public Element getLow_diff() {
        return low_diff;
    }

    public void setLow_diff(Element low_diff) {
        this.low_diff = low_diff;
    }

    public float getAvg_diff() {
        return avg_diff;
    }

    public void setAvg_diff(float avg_diff) {
        this.avg_diff = avg_diff;
    }

    public Element getHigh_volume() {
        return high_volume;
    }

    public void setHigh_volume(Element high_volume) {
        this.high_volume = high_volume;
    }

    public Element getLow_volume() {
        return low_volume;
    }

    public void setLow_volume(Element low_volume) {
        this.low_volume = low_volume;
    }

    public float getAvg_volume() {
        return avg_volume;
    }

    public void setAvg_volume(float avg_volume) {
        this.avg_volume = avg_volume;
    }
}

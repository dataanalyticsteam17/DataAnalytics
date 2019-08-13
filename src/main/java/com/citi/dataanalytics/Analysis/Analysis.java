package com.citi.dataanalytics.Analysis;

import com.citi.dataanalytics.entity.Stock;

import java.util.ArrayList;

public class Analysis {
    String stock_name;

    Element high_price;
    Element low_price;
    float avg_price;

    Element high_priceup;
    Element  low_pricedown;
    float avg_pricechange;

    Element high_diff;
    Element low_diff;
    float avg_diff;

    Element high_volume;
    Element low_volume;
    float avg_volume;

    public Analysis(String stock_name, Element high_price, Element low_price, float avg_price, Element high_priceup, Element low_pricedown, float avg_pricechange, Element high_diff, Element low_diff, float avg_diff, Element high_volume, Element low_volume, float avg_volume) {
        this.stock_name = stock_name;
        this.high_price = high_price;
        this.low_price = low_price;
        this.avg_price = avg_price;
        this.high_priceup = high_priceup;
        this.low_pricedown = low_pricedown;
        this.avg_pricechange = avg_pricechange;
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

    public Element getHigh_priceup() {
        return high_priceup;
    }

    public void setHigh_priceup(Element high_priceup) {
        this.high_priceup = high_priceup;
    }

    public Element getLow_pricedown() {
        return low_pricedown;
    }

    public void setLow_pricedown(Element low_pricedown) {
        this.low_pricedown = low_pricedown;
    }

    public float getAvg_pricechange() {
        return avg_pricechange;
    }

    public void setAvg_pricechange(float avg_pricechange) {
        this.avg_pricechange = avg_pricechange;
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

    @Override
    public String toString() {
        return "Analysis{" +
                "stock_name='" + stock_name + '\'' +
                ", high_price=" + high_price.toString() +
                ", low_price=" + low_price.toString()+
                ", avg_price=" + avg_price +
                ", high_priceup=" + high_priceup.toString() +
                ", low_pricedown=" + low_pricedown.toString() +
                ", avg_pricechange=" + avg_pricechange +
                ", high_diff=" + high_diff.toString() +
                ", low_diff=" + low_diff.toString() +
                ", avg_diff=" + avg_diff +
                ", high_volume=" + high_volume.toString() +
                ", low_volume=" + low_volume.toString() +
                ", avg_volume=" + avg_volume +
                '}';
    }
}

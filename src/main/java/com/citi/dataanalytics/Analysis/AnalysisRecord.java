package com.citi.dataanalytics.Analysis;

public class AnalysisRecord {
    private String stock_name, date;
    private float open, high, low, close, volume;
    private float price_diff,max_min;

    public AnalysisRecord(String stock_name, String date, float open, float high, float low, float close, float volume, float price_diff, float max_min) {
        this.stock_name = stock_name;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.price_diff = price_diff;
        this.max_min = max_min;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getPrice_diff() {
        return price_diff;
    }

    public void setPrice_diff(float price_diff) {
        this.price_diff = price_diff;
    }

    public float getMax_min() {
        return max_min;
    }

    public void setMax_min(float max_min) {
        this.max_min = max_min;
    }



    @Override
    public String toString() {
        return "AnalysisRecord{" +
                "stock_name='" + stock_name + '\'' +
                ", date='" + date + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", price_diff=" + price_diff +
                ", max_min=" + max_min +
                '}';
    }
}

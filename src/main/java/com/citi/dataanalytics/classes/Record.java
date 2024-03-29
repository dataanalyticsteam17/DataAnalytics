package com.citi.dataanalytics.classes;

public class Record {
    private String stock_name, date;
    private int time;
    private float open, high, low, close, volume;
    private float split_factor, earnings, dividends;

    public Record(String stock_name, String date, int time, float open, float high, float low, float close, float volume, float split_factor, float earnings, float dividends) {
        this.stock_name = stock_name;
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.split_factor = split_factor;
        this.earnings = earnings;
        this.dividends = dividends;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public Record(String date, int time, float open, float high, float low, float close, float volume, float split_factor, float earnings, float dividends) {
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.split_factor = split_factor;
        this.earnings = earnings;
        this.dividends = dividends;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    public float getSplit_factor() {
        return split_factor;
    }

    public void setSplit_factor(float split_factor) {
        this.split_factor = split_factor;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public float getDividends() {
        return dividends;
    }

    public void setDividends(float dividends) {
        this.dividends = dividends;
    }

    @Override
    public String toString() {
        return "Record{" +
                "date='" + date + '\'' +
                ", time=" + time +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", split_factor=" + split_factor +
                ", earnings=" + earnings +
                ", dividends=" + dividends +
                '}';
    }
}

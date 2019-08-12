package com.citi.dataanalytics.entity;

public class Stock {
    int id;
    String date;
    String time;
    double open;
    double high;
    double low;
    double close;
    int volume;
    int splitFactor;
    int earnings;
    int dividends;
    int extrapolation;

    public Stock(String date, String time, double open, double high, double low, double close, int volume, int splitFactor, int earnings, int dividends, int extrapolation) {
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.splitFactor = splitFactor;
        this.earnings = earnings;
        this.dividends = dividends;
        this.extrapolation = extrapolation;
    }

    public Stock(int id, String date, String time, double open, double high, double low, double close, int volume, int splitFactor, int earnings, int dividends, int extrapolation) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.splitFactor = splitFactor;
        this.earnings = earnings;
        this.dividends = dividends;
        this.extrapolation = extrapolation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getSplitFactor() {
        return splitFactor;
    }

    public void setSplitFactor(int splitFactor) {
        this.splitFactor = splitFactor;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getDividends() {
        return dividends;
    }

    public void setDividends(int dividends) {
        this.dividends = dividends;
    }

    public int getExtrapolation() {
        return extrapolation;
    }

    public void setExtrapolation(int extrapolation) {
        this.extrapolation = extrapolation;
    }
}

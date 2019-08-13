package com.citi.dataanalytics.Analysis;

import com.citi.dataanalytics.classes.Readdata;
import com.citi.dataanalytics.classes.Record;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public static ArrayList<AnalysisRecord> get_analysisrecord(String start_date, String end_date, String symbol)
            throws IOException,java.text.ParseException{
        ArrayList<AnalysisRecord> records = new ArrayList<AnalysisRecord>();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date start = sdf.parse(start_date);
        Date end = sdf.parse(end_date);


        float last_day_close=0;
        while (start.before(end) || start.equals(end)){
            // System.out.println(sdf.format(start));
            ArrayList<String> ls = Readdata.readData(sdf.format(start),sdf.format(start),symbol);
            if (!ls.isEmpty()) {
                //String date =" ";
                float open = Float.parseFloat(ls.get(0).split(",")[2]);
                float close = Float.parseFloat(ls.get(ls.size() - 1).split(",")[5]);
                float volume =0;
                float high = Float.NEGATIVE_INFINITY, low = Float.POSITIVE_INFINITY;
                for (int i = 0; i < ls.size(); i++) {
                    if (Float.parseFloat(ls.get(i).split(",")[3]) > high)
                        high = Float.parseFloat(ls.get(i).split(",")[3]);
                    if (Float.parseFloat(ls.get(i).split(",")[4]) < low)
                        low = Float.parseFloat(ls.get(i).split(",")[4]);
                        volume=volume+ Float.parseFloat(ls.get(ls.size() - 1).split(",")[6]);
                }
                float max_min = (high-low)/low *100;
                if(start.equals(sdf.parse(start_date))){
                    records.add(new AnalysisRecord(symbol,sdf.format(start), open, high, low, close,volume,
                            0,
                            max_min));
                    last_day_close=close;
                }
               else {
                   records.add(new AnalysisRecord(symbol,sdf.format(start), open, high, low, close,volume,
                        (close-last_day_close )/last_day_close*100,
                       max_min));
                    last_day_close=close;
               }
           }

            Calendar ca = Calendar.getInstance();
            ca.setTime(start);
            ca.add(Calendar.DAY_OF_YEAR, 1);//day+1
            start = ca.getTime();
        }
        return records;
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

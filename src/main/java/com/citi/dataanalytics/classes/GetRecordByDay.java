package com.citi.dataanalytics.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/*
such as: String start_time ="20160104",end_time = "20160104",symbol = "a";

input:acessdatabyday(String start_date, String end_date,String symbol)

output:
Record{date='20160104', time=0, open=41.08, high=41.19, low=40.34, close=40.68, volume=0.0, split_factor=0.0, earnings=0.0, dividends=0.0}*/
public class GetRecordByDay {
//    public static void main(String[] args){
//        String start_time ="20160104",end_time = "20160304",symbol = "a";
//        ArrayList<Record> record_list = acessdatabyday(start_time ,end_time,symbol);
//        //System.out.println(record_list.get(0).toString());
//        for (Record r :record_list){
//            System.out.println(r.toString());
//        }
//    }
    public static ArrayList<Record> acessdatabyday(String start_date, String end_date,String symbol) {
        ArrayList<Record> records = new ArrayList<Record>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date start = sdf.parse(start_date);
            Date end = sdf.parse(end_date);

            while (start.before(end) || start.equals(end)) {
                // System.out.println(sdf.format(start));
                ArrayList<String> ls = Readdata.readData(sdf.format(start), sdf.format(start), symbol);
                if (!ls.isEmpty()) {
                    float open = Float.parseFloat(ls.get(0).split(",")[2]);
                    float close = Float.parseFloat(ls.get(ls.size() - 1).split(",")[5]);
                    float high = Float.NEGATIVE_INFINITY, low = Float.POSITIVE_INFINITY;
                    float volume = 0;
                    for (int i = 0; i < ls.size(); i++) {
                        if (Float.parseFloat(ls.get(i).split(",")[3]) > high)
                            high = Float.parseFloat(ls.get(i).split(",")[3]);
                        if (Float.parseFloat(ls.get(i).split(",")[4]) < low)
                            low = Float.parseFloat(ls.get(i).split(",")[4]);
                        volume = volume + Float.parseFloat(ls.get(ls.size() - 1).split(",")[6]);
                    }
                    records.add(new Record(symbol
                            , sdf.format(start)
                            , 0
                            , open
                            , high
                            , low
                            , close
                            , volume
                            , 0
                            , 0
                            , 0));
                }

                Calendar ca = Calendar.getInstance();
                ca.setTime(start);
                ca.add(Calendar.DAY_OF_YEAR, 1);//day+1
                start = ca.getTime();
            }
        }catch (java.text.ParseException e){
            System.out.println(e.getMessage());
        }
        return  records;
    }
}

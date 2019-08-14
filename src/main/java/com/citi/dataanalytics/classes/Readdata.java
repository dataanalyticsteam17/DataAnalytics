package com.citi.dataanalytics.classes;

import com.csvreader.CsvReader;
import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/*
* acessData("935","940",start_time ,end_time,symbol);
* acessData(935,940,start_time ,end_time,symbol);
* acessData(start_time ,end_time,symbol);
* */
public class Readdata {
public  static String abspath="C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\Test Data\\Quant Quote Market Data - Jan to Mar 2016\\";
//    public static void main(String[] args){
//        String start_time ="20160104",end_time = "20160104",symbol = "a";
//        ArrayList<String> record_list = Readdata.readData(start_time ,end_time,symbol);
//            //System.out.println(record_list.get(0).toString());
//            for (String r :record_list){
//                System.out.println(r);
//            }
//    }

    public static ArrayList<Record> acessData(int start_time, int end_timn,String start_date,
                                              String end_date,String symbol) {
        ArrayList<String> alldata , newlist= new  ArrayList<String>();
        ArrayList<Record> record_list = new ArrayList<Record>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        alldata =readData(start_date ,end_date,symbol);
            try {
                for( int i=0;i<alldata.size();i++) {
                    String str = alldata.get(i);
                    String[] str_list = str.split(",");
                    if (Integer.parseInt(str_list[1]) >= start_time && Integer.parseInt(str_list[1]) <= end_timn)
                        newlist.add(alldata.get(i));
                    else continue;
                    if (sdf1.parse(str_list[0]).after(sdf1.parse(end_date))) break;
                }
                alldata.clear();
                for (String str : newlist) {
                    String[] str_list = str.split(",");
                    record_list.add(new Record(symbol
                            ,str_list[0]
                            ,Integer.parseInt(str_list[1]),
                            Float.parseFloat(str_list[2]),
                            Float.parseFloat(str_list[3])
                            , Float.parseFloat(str_list[4])
                            , Float.parseFloat(str_list[5])
                            , Float.parseFloat(str_list[6])
                            , Float.parseFloat(str_list[7])
                            , Float.parseFloat(str_list[8])
                            , Float.parseFloat(str_list[9])));
                }
            }catch (java.text.ParseException e){
                System.out.println(e.getMessage());
            }
         return record_list;
    }
    public static ArrayList<Record> acessData(String start_time, String end_timn,
                                              String start_date, String end_date,String symbol) {
        ArrayList<String> alldata , newlist= new  ArrayList<String>();
        ArrayList<Record> record_list = new ArrayList<Record>();
        String time_st = start_date+implet_4bit_time(start_time);
        String time_en = end_date+implet_4bit_time(end_timn);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        try{
        Date  d_time_st  =sdf.parse(time_st);
        Date  d_time_en  =sdf.parse(time_en);
        String last  = " ";
        alldata =readData(start_date ,end_date,symbol);

            for( int i=0;i<alldata.size();i++){
                String str= alldata.get(i);
                String[] str_list = str.split(",");
                if(sdf1.parse(str_list[0]).before(sdf1.parse(start_date))) continue;

                if(!last.equals(str_list[0])){
                    String time_st_h = str_list[0]+implet_4bit_time(start_time);
                    d_time_st  =sdf.parse(time_st_h);
                    String time_en_h = str_list[0]+implet_4bit_time(end_timn);
                    d_time_en =sdf.parse(time_en_h);
                }
                else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(d_time_st);
                    calendar.add(Calendar.MINUTE, 1);
                    d_time_st=calendar.getTime();
                }
                String time_fromrecord  = str_list[0]+implet_4bit_time(str_list[1]);
                Date  d_fromrecord =sdf.parse(time_fromrecord);
                if(d_fromrecord.before(d_time_st)) continue;
                if((d_fromrecord.equals(d_time_st) || d_fromrecord.after(d_time_st ))
                        && ((d_fromrecord.before(d_time_en) || d_fromrecord.equals(d_time_en) ))){
                    newlist.add(str);
                }
                if(d_fromrecord.after(d_time_en))continue;
                if(sdf1.parse(str_list[0]).after(sdf1.parse(end_date))) break;

            }

            alldata.clear();
            for (String str : newlist) {
                String[] str_list = str.split(",");
                record_list.add(new Record(symbol
                        ,str_list[0]
                        ,Integer.parseInt(str_list[1])
                        ,Float.parseFloat(str_list[2])
                        ,Float.parseFloat(str_list[3])
                        , Float.parseFloat(str_list[4])
                        , Float.parseFloat(str_list[5])
                        , Float.parseFloat(str_list[6])
                        , Float.parseFloat(str_list[7])
                        , Float.parseFloat(str_list[8])
                        , Float.parseFloat(str_list[9])));
            }
        }catch (java.text.ParseException e){
             System.out.println(e.getMessage());
        }
        return record_list;
    }


    public static  String implet_4bit_time(String a){
        if(a.length() == 4) return a;
        else {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(a);
            return  sb.toString();
        }
    }

    public static ArrayList<Record> acessData(String start_time, String end_time,String symbol) {
        ArrayList<String> alldata ;
        ArrayList<Record> record_list = new ArrayList<Record>();
        alldata =readData(start_time ,end_time,symbol);

        for (String str : alldata) {
            String[] str_list = str.split(",");
            record_list.add(new Record(symbol
                    ,str_list[0]
                    ,Integer.parseInt(str_list[1])
                    ,Float.parseFloat(str_list[2])
                    ,Float.parseFloat(str_list[3])
                    , Float.parseFloat(str_list[4])
                    , Float.parseFloat(str_list[5])
                    , Float.parseFloat(str_list[6])
                    , Float.parseFloat(str_list[7])
                    , Float.parseFloat(str_list[8])
                    , Float.parseFloat(str_list[9])));
        }
        return record_list;
    }
    public static  ArrayList<String>  readData( String start_time, String end_time,String symbol) {
        ArrayList<String> allString = new ArrayList<String>();
            try{

            String filepath;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date start = sdf.parse(start_time);
            Date end = sdf.parse(end_time);
            while (start.before(end)|| start.equals(end)) {
                String reStr = sdf.format(start);
                filepath = abspath      + "allstocks_" + reStr + "\\table_" + symbol + ".csv";
                readCsv(allString,filepath);
                Calendar ca = Calendar.getInstance();
                ca.setTime(start);
                ca.add(Calendar.DAY_OF_YEAR, 1);//day+1
                start = ca.getTime();
            }
        }catch (java.text.ParseException e){
                System.out.println(e.getMessage());
        }

        return allString;
    }

    public static void readCsv( ArrayList<String> allString,String filepath) {
        try{
            if (new File(filepath).exists()) {
                CsvReader csvReader = new CsvReader(filepath, ' ', Charset.forName("UTF-8"));
                while (csvReader.readRecord()) {
                    allString.add(csvReader.get(0));
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

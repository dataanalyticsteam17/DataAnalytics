package com.citi.dataanalytics.classes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Readdata {

    public static ArrayList<Record> acessDate(String start_time, String end_time, String symbol) {
        //String start_time ="20160104",end_time = "20160505",symbol = "a";
        ArrayList<String> alldata = new ArrayList<String>();
        ArrayList<Record> record_list = new ArrayList<Record>();
        try {
            alldata = readalldata(symbol, start_time, end_time);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (String str : alldata) {
            String[] str_list = str.split(",");
            //String date, int time, float open, float high, float low, float close, long volume, float split_factor, float earnings, float dividends
            record_list.add(new Record(str_list[0],
                    Integer.parseInt(str_list[1]),
                    Float.parseFloat(str_list[2]),
                    Float.parseFloat(str_list[3])
                    , Float.parseFloat(str_list[4])
                    , Float.parseFloat(str_list[5])
                    , Long.parseLong(str_list[6])
                    , Float.parseFloat(str_list[7])
                    , Float.parseFloat(str_list[8])
                    , Float.parseFloat(str_list[9])
            ));
        }
        return record_list;
//        for (Record it : record_list){
//            System.out.println(it.toString());
//        }
//        System.out.println(alldata.size());
    }

    public static ArrayList<String> readalldata(String symbol, String start_time, String end_time) throws IOException, java.text.ParseException {
        ArrayList<String> allline = new ArrayList<String>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date start = sdf.parse(start_time);
        Date end = sdf.parse(end_time);


        while (start.before(end)) {
            String reStr = sdf.format(start);
            String filepath = "C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\Test Data\\Quant Quote Market Data - Jan to Mar 2016\\"// the path of files
                    + "allstocks_" + reStr + "\\table_" + symbol + ".csv";
            File isfile = new File(filepath);
            if (isfile.exists()) {
                allline.addAll(readCsv(filepath));
            }

            Calendar ca = Calendar.getInstance();
            ca.setTime(start);
            ca.add(Calendar.DAY_OF_YEAR, 1);//day+1
            start = ca.getTime();
        }
        return allline;

    }


    public static ArrayList<String> readCsv(String filepath) throws IOException {
        ArrayList<String> allString = new ArrayList<String>();
        File csv = new File(filepath);
        csv.setReadable(true);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        if (csv.exists()) {
            while ((line = br.readLine()) != null) {
                everyLine = line;
                // System.out.println(everyLine);
                allString.add(everyLine);


            }

        }
        return allString;
    }

}

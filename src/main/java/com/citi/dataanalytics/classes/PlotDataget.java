package com.citi.dataanalytics.classes;

import java.util.ArrayList;

public class PlotDataget {

//    public static void main(String[] args){
////        String value_name="Close Price",start_time = "20160108",symbol = "a";
////        String[][] result=getDataofday(value_name,start_time,symbol);
////       System.out.println(result[0][0]+" "+result[0][1]);
//
////        String value_name="Open Price",start_time ="20160104",end_time = "20160104",symbol = "a";
////        String[][] result=getDataoftime(value_name,start_time,end_time,symbol);
////        System.out.println(result[result.length-1][0]+" "+result[result.length-1][1]);
//   }
   public static String[][]getPlotData(String value_name, String start_date,String end_date,String symbol) {
        if(start_date.equals(end_date)) return getDataofday(value_name,start_date,symbol);
        else return getDataoftime(value_name,start_date,end_date,symbol);
   }

    public static String[][] getDataofday(String value_name, String day,String symbol) {
        ArrayList<String> ls= Readdata.readData(day,day,symbol);
        //if (ls.isEmpty()) return null;
        String[][] data = new String[ls.size()][2];

        for (int i=0;i<ls.size();i++){
            String[] str = ls.get(i).split(",");
            data[i][0]=str[0]+Readdata.implet_4bit_time(str[1]);
            data[i][1]=str[return_index(value_name)];

        }

        return data;
    }
    public static String[][] getDataoftime(String value_name,String start_date,String end_date,String symbol){
        ArrayList<String> ls= Readdata.readData(start_date,end_date,symbol);
        //System.out.println(ls.isEmpty());
        String[][] data = new String[ls.size()][2];
        for (int i=0;i<ls.size();i++){
            String[] str = ls.get(i).split(",");
            data[i][0]=str[0]+Readdata.implet_4bit_time(str[1]);
            data[i][1]=str[return_index(value_name)];
        }

        return data;
    }
    public static int return_index(String value_name){
        switch (value_name){
            case "Open Price" : return 2;
            case "High Price" :return 3;
            case "Low Price":return 4;
            case "Close Price":return 5;
            case  "Volume":return 6;
//            case "split_factor": return 7;
//            case  "earning":return 8;
//            case "dividends" :return 9;
            default:return -1;
        }
    }

}

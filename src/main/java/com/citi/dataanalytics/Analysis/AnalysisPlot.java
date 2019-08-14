package com.citi.dataanalytics.Analysis;

import java.util.ArrayList;

public class AnalysisPlot {
//    public static void main(String[] args) {
////        String start_time ="20160104",end_time = "20160304",symbol = "a";
////        String[][] str = getPriceChange(start_time,end_time,symbol);
////        for (int i=0;i<str.length;i++){
////            System.out.println(str[i][0]+"  "+str[i][1]);
////        }
//        String start_time ="20160104",end_time = "20160304",symbol = "a";
//        String[][] str = getMaxMinChange(start_time,end_time,symbol);
//        for (int i=0;i<str.length;i++){
//            System.out.println(str[i][0]+"  "+str[i][1]);
//        }
//    }
    public static String[][] getPriceChange(String start_date,String end_date,String symbol){
        ArrayList<AnalysisRecord> list = AnalysisOperation.get_analysisrecord(start_date,end_date,symbol);
        String[][] str = new String[list.size()][2];
        for (int i=0;i<list.size();i++){
            str[i][0]=list.get(i).getDate();
            str[i][1]=Float.toString(list.get(i).getPrice_diff());
        }
        return str;
    }
    public static String[][] getMaxMinChange(String start_date,String end_date,String symbol){
        ArrayList<AnalysisRecord> list = AnalysisOperation.get_analysisrecord(start_date,end_date,symbol);
        String[][] str = new String[list.size()][2];
        for (int i=0;i<list.size();i++){
            str[i][0]=list.get(i).getDate();
            str[i][1]=Float.toString(list.get(i).getMax_min());
        }
        return str;
    }
}

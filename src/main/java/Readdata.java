import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Readdata {

    public static void main(String[] args) {
        String start_time ="20160104",end_time = "20160505";
        String symbol = "a";
        try {
            System.out.println(readalldata(symbol,start_time, end_time).size());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static ArrayList<String> readalldata(String symbol,String  start_time, String end_time) throws IOException, java.text.ParseException {
        ArrayList<String> allline= new ArrayList<String>();

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date start =sdf.parse(start_time);
        Date end =sdf.parse(end_time);


        while(start.before(end)) {
            String reStr = sdf.format(start);
            String filepath = "C:\\Users\\jw\\Desktop\\DataAnalysis\\Data"
                    + " Analytics\\Test Data\\Quant Quote Market Data - Jan to Mar 2016\\"
                    + "allstocks_"+reStr+"\\table_"+symbol+".csv";
            File isfile = new File(filepath);
            if(isfile.exists()) {
                allline.addAll(readCsv(filepath)) ;
            }

            Calendar ca = Calendar.getInstance();
            ca.setTime(start);
            ca.add(Calendar.DAY_OF_YEAR,1);//day+1
            start = ca.getTime();
        }
        return allline;

    }



    // 读取csv文件的内容
    public static ArrayList<String> readCsv(String filepath) throws IOException {
        ArrayList<String> allString = new ArrayList<String>();
        File csv = new File(filepath); // CSV文件路径
        csv.setReadable(true);//设置可读
        csv.setWritable(true);//设置可写
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        if (csv.exists()) {
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                everyLine = line;
                System.out.println(everyLine);
                allString.add(everyLine);

            }

        }
        return allString;
    }

}

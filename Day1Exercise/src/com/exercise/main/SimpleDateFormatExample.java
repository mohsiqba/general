package com.exercise.main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {

    public static void main(String[] args) {

        Date now = new Date();
        String datetimeStr = now.toString();
        String time="Thu Jan 01 00:00:00 IST 1970";
        SimpleDateFormat format = new SimpleDateFormat(
                   "EEE MMM dd");
        //MM/dd/yyyy HH:mm z
        try {
            Date parseDate = format.parse(datetimeStr);
            System.out.println(now);
            System.out.println(parseDate.toString());
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        
    }

}
package com.example.demo;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class GFG {

	static void
    findDifference(String start_date,
                   String end_date)
    {
 
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
 
        // Try Block
        try {
 
            // parse method is used to parse
            // the text from a string to
            // produce the date
            java.util.Date d1 =  sdf.parse(start_date);
            java.util.Date d2 =  sdf.parse(end_date);
 
            // Calculate time difference
            // in milliseconds
            long difference_In_Time
                = d2.getTime() - d1.getTime();
long l =TimeUnit.DAYS.convert(difference_In_Time,TimeUnit.MILLISECONDS) ;
            // Calculate time difference in
            // seconds, minutes, hours, years,
            // and days
            long difference_In_Seconds
                = (difference_In_Time
                   / 1000)
                  % 60;
 
            long difference_In_Minutes
                = (difference_In_Time
                   / (1000 * 60))
                  % 60;
 
            long difference_In_Hours
                = (difference_In_Time
                   / (1000 * 60 * 60))
                  % 24;
 
            long difference_In_Years
                = (difference_In_Time
                   / (1000l * 60 * 60 * 24 * 365));
 
            long difference_In_Days
                = (difference_In_Time
                   / (1000 * 60 * 60 * 24))
                  % 365;
 
            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds
 
            System.out.print(
                "Difference "
                + "between two dates is: ");
 
            System.out.println(
                difference_In_Years
                + " years, "
                + difference_In_Days
                + " days, "
                + difference_In_Hours
                + " hours, "
                + difference_In_Minutes
                + " minutes, "
                + difference_In_Seconds
                + " seconds");
            
            System.out.println(l+"---");

        }
        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        // Given start Date
        String start_date
            = "10-01-2020 01:10:00";
 
        // Given end Date
        String end_date
            = "10-01-2020 23:59:59";
 
        // Function Call
        findDifference(start_date, end_date);
    }

}

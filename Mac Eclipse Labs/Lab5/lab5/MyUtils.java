package lab5;

import java.util.*;

public class MyUtils 
{
  public static String dateToString(GregorianCalendar date)
  // receives: a date as a GregorianCalendar
  // returns: received date as a string in format mm/dd/yyyy
  {  String temp="";
     int month = date.get(Calendar.MONTH);
     month++; // add 1 due to zero-based months
     int day = date.get(Calendar.DAY_OF_MONTH);
     int year = date.get(Calendar.YEAR);
     temp = month + "/" + day + "/" + year;
     return temp;
  }
  public static GregorianCalendar stringToDate(String theDate)
  // receives: theDate as a String in format mm/dd/yyyy
  // returns: received date as a correct GregorianCalendar object
  {
    StringTokenizer tokenizer = new StringTokenizer(theDate, "/");
    String temp = tokenizer.nextToken();  // grabs up to "/"
    int month=0, day=1, year=2000;  // default date values
    try {
      month = Integer.parseInt(temp);
      month--;  // zero-based months
      temp = tokenizer.nextToken();
      day = Integer.parseInt(temp);
      temp = tokenizer.nextToken();
      year = Integer.parseInt(temp);
    }
    catch(NumberFormatException e) {
       System.out.println("error extracting date, using default date");
    }
    return new GregorianCalendar(year, month, day);
  }
}// end of MyUtils class
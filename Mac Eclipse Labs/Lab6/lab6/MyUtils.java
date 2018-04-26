package lab6;

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

	// put the next 2 methods in MyUtils class


	// pre: in is open and ready to read from
	// post: reads 1 VetVisit (either urgent or standard) and returns that as a VetVisit instance of
	//       the appropriate type, returns null if no visit available to read or end of visit list.
	public static VetVisit vetVisitReadFromScanner(Scanner in)
	   {
		   VetVisit visit = null;
		   int aLicenseNumber;
		   String line1,  aVisitId;
		   String aDoctor, aLocation, aDate, aOtherCare, aTreatment, aDiagnosis, aVaccines;
		   aVisitId = in.next();
                 // now check did we read the **** value?
		   if(aVisitId.equals("****"))
			   return null;  // if so, return null, so caller knows no more data 
		   aDate = in.next();
		   aLocation = in.next();
		   aDoctor = in.nextLine();
		   line1 = in.nextLine();  
		   // now check if what we see next is a license number (for Standard) or it must be an Urgent type 
		   if(in.hasNextInt())
		   {	   aVaccines = line1;
			   aLicenseNumber = in.nextInt();
			   aOtherCare = in.nextLine();
			   visit = new VetVisitStandard(aVisitId,aDate,aDoctor,aLocation, aVaccines, aLicenseNumber,aOtherCare);
		   }
		   else
		   {
			   aDiagnosis = line1;
			   aTreatment = in.nextLine();
			   visit = new VetVisitUrgent(aVisitId, aDate, aDoctor, aLocation,
					       aDiagnosis, aTreatment);
			   
					         			   
		   }
		   return visit;  // sends back one of the two possible visit types, whichever was created.
		   
	   }   
	   
	   
	// belongs in MyUtils
	// use this to populate/read the VetVisitList for a HousePet, reads 1 entire set of data
	// for the entire list of vetvisits for the current HousePet, called from HousePet's read from Scanner
	public static void vetVisitListReadFromScanner(Scanner in, VetVisitList aList)
	{
		VetVisit visit = MyUtils.vetVisitReadFromScanner(in);
		while (visit != null)
		{
			aList.add(visit);
			visit = MyUtils.vetVisitReadFromScanner(in);
			
		}
		
	}

}// end of MyUtils class
package lab5;

import java.util.GregorianCalendar;
import java.util.Random;

public abstract class VetVisit implements Comparable <VetVisit>
{
	private String visitId;
	private GregorianCalendar date;
	public static final int MAX_ID_LENGTH = 4;
	private String doctor;
	private String location;

	public VetVisit()
	{
		this.setVisitId(generateNewId());
		this.setDate("1/1/2000");
		this.setDoctor("**no doctor**");
		this.setLocation("**no location**");
	}
	public VetVisit(String theDate, String theDoctor, String theLocation)
	{
		this.setDate(theDate);
		this.setDoctor(theDoctor);
		this.setVisitId(generateNewId());
		this.setLocation(theLocation);

	}
	//pre: none
	//post: returns a textual string representing this vet visit
	public String toString()
	{
		String temp = "";
		temp+= this.getVisitId() + " " +
				this.getDateString() + " " +
				this.getDoctor() + " " +
				this.getLocation() ;
		return temp;

	}
	//pre:  none                                                                                       
	//post: returns the id of the visit
	public String getVisitId()
	{
		return this.visitId;
	}
	//pre: none                                                                                        
	//post: returns the doctor                                                   
	public String getDoctor()
	{
		return this.doctor;
	}
	//pre: none
	//post: return this location
	public String getLocation()
	{
		return this.location;
	}

	//pre: none                                                                                        
	//post: returns the date in format mm/dd/yyyy                                                      
	public String getDateString()
	{
		return lab5.MyUtils.dateToString(date);
	}
	public GregorianCalendar getDateCalendar()
	{
		return this.date;
	}
	//pre: none
	//post: returns a 4 character id (random, and we'll assume unique)
	private String generateNewId()
	{ 
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = "";
		Random rand = new Random();
		for(int i=0; i< MAX_ID_LENGTH; i++)
		{   int randNum = rand.nextInt(chars.length());
		char ch = chars.charAt(randNum);
		result += ch;
		}
		return result;
	}   
	// pre: the vetVisitId has length 4, letters/digits case-sensitive                               
	// post: the id has been set to the first 4 characters of theVetVisitId                         
	public void setVisitId(String theVisitId)
	{
		if(theVisitId.length() > MAX_ID_LENGTH)
			theVisitId=theVisitId.substring(0,MAX_ID_LENGTH);
		this.visitId = theVisitId;
	}
	//pre: theDate is a valid date as a String form mm/dd/yyyy including /'s                           
	//post: theDate is stored as given date                                                            
	public void setDate(String theDate)
	{
		this.date = MyUtils.stringToDate(theDate);
	}
	//pre: none                                                                                        
	//post: theAmount stored into this transaction                                                     
	public void setDoctor(String theDoctor)
	{
		if(theDoctor.equals(""))
			theDoctor="**no doctor**";
		this.doctor = theDoctor.toUpperCase().trim();
	}
	//pre: theLocation is not empty, if so uses **no location**
	// post: stores theLocation or uses **no location** for empty string
	public void setLocation(String theLocation)
	{
		if(theLocation.equals(""))
		{
			theLocation="**no location**";
		}
		this.location = theLocation;
	}
	//pre: visit is not null                                                                         
	// post: returns < 0, 0, > 0 if this date >, ==, < if == compares transactionid                          
	public int compareTo(VetVisit visit)
	{
		int result = this.getDateCalendar().compareTo(visit.getDateCalendar());
		if(result == 0)
		{
			result = this.getVisitId().compareTo(visit.getVisitId());

		}
		return result;
	}
	//@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((visitId == null) ? 0 : visitId.hashCode());
		return result;
	}
	//@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VetVisit other = (VetVisit) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (visitId == null) {
			if (other.visitId != null)
				return false;
		} else if (!visitId.equals(other.visitId))
			return false;
		return true;
	}
}// end of VetVisit class

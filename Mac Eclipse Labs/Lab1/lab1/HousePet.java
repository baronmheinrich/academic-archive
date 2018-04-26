package lab1;

import java.util.Scanner;

public class HousePet 
{
	private int theChipId;
	private String theName;
	private String thePetType;
	private double theAge;
	
	// default constructor, creates a default HousePet instance
    // with chipId as 0, name as "**no name**", petType as "**no type**", 
    // and age as 0.0.
	public HousePet()
	{
		theChipId=0;
		theName="**No Name**";
		thePetType="**no type**";
		theAge=0.0;
	}
	
	//pre: Receives data to initialize constructor
	//post: creates house pet with given data
	public HousePet(int theChipId, String theName,  String thePetType, double theAge)
	{
		this.theChipId=theChipId;
		this.theName=theName;
		this.thePetType=thePetType;
		this.theAge=theAge;
		
		//following if statements check the data
		//if any of the data is invalid, makes the field the default
		if(theChipId<0)
		    {
			theChipId=0;
		    }
		
		if(theName.length()==0)
		    {
			theName="**No Name**";
		    }
		
		if(thePetType.length()==0)
		    {
			thePetType="**no type**";
		    }
		
		if(theAge<0.0)
		    {
			theAge=0.0;
		    }
		
	}
	    // creates a HousePet instance with the given data, if any is invalid
	    // puts default value into field ( invalid data is a negative chipId or
	    //  negative age)
	
	//pre: none
	//post: returns ChipId Value
	public int getChipId()
	{
		return theChipId;
	} // returns this house pet's chipId
	
	//pre: none
	//post: returns the name
	public String getName()
	{
		return theName;
	} // returns name of this house pet
	
	//pre: none
	//post: returns Pet Type
	public String getPetType()
	{
		return thePetType;
	} // returns the petType of this house pet
	
	//pre: none
	//Post: returns age value
	public double getAge()
	{
		return theAge;
		
	} // returns the age of this house pet
	
	//pre: chip ID value
	//post: sets chip ID value to given chip ID, 0 if invalid
	public void setChipId(int theChipId)
	{
		this.theChipId=theChipId;
		
		if(theChipId<0)
	    {
		this.theChipId=0;
	    }
	
	} // sets this HousePet's chipId to given number
	    // or to 0 if invalid chipId given
	
	//pre: theName String
	//post: sets given string as name, returns no name if invalid
	public void setName(String theName)
	{
		this.theName=theName;
		if(theName.length()==0)
	    {
		this.theName="**No Name**";
	    }
	}
	//sets this HousePet's name to theName, if 
	// theName is blank, then uses default value
	
	//pre: thePetType string
	//post: sets the inputed string as the Pet Type
	public void setPetType(String thePetType)
	{
		this.thePetType=thePetType;
		
		if(thePetType.length()==0)
	    {
		this.thePetType="**no type**";
	    }
	}  //sets this HousePet's type to given type
	   // if thePetType is blank, then uses default value
	
	//pre: theAge double value
	//post: sets the inputed value, returns 0.0 if invalid
	public void setAge(double theAge)
	{
		this.theAge=theAge;
		
		if(theAge<0.0)
	    {
		this.theAge=0.0;
	    }
	} // sets this HousePet's age to the given age
	
	//pre: none
	//post: returns readable string from setters
	public String toString()
	{
		String output="Your pet's chip ID is "+theChipId+". Your pet's name is "+theName+". Your pet is a "+ thePetType+". Your pet is "+theAge+" years old.";
		return output;
	} // returns a readable string 
	                // of this HousePet as ONE line of understandable text
	
	//pre: scanner
	//post: returns true and sets data if all the data in the document is correct
	public boolean readFromScanner(Scanner inputSource)
	{
	    int aChipId=0;
	    String aName="";
	    String aType="";
	    double aAge=0.0;

	    if(inputSource.hasNext())
		{
		    aChipId=inputSource.nextInt();
		    inputSource.nextLine();
		
		    if(inputSource.hasNext())
			{
			    aName=inputSource.next();
			    
			    if(inputSource.hasNext())
				{
				    aType=inputSource.next();
				    
				    if(inputSource.hasNext())
					{
					    aAge=inputSource.nextDouble();
					    this.theAge=aAge;
					    this.theName=aName;
					    this.thePetType=aType;
					    this.theChipId=aChipId;
					    return true;
					}//end of Double
				    return false;
				}// end of aType
			    return false;
			}//end of if input Source
		    return false;
		}// end of if next
	    
	    else
	    	return false;	
	} 
}

	// tries to read and store data
	// from inputSource (on 4 lines of input as previously described, 1 piece of
	// data on each line in order described above) 
	// returns true on success(all data found), 
	// if unsuccessful, sets all 4 values to default values, skips past 4 lines of input
	// and then returns false
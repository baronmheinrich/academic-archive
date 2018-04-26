package lab6;

public class VetVisitStandard extends VetVisit{

	private String vaccines;
	private int licenseId;
	private String otherCare;
	
	//pre: n/a
	//post: default constructor
	public VetVisitStandard()
	{
		super();
		this.setLicenseId(0);
		this.setOtherCare("**No Care**");
		this.setVaccines("**No Vaccines**");
	}
	
	//pre: super arguments and standard arguments
	//post: constructor with super and standard's arguments
	//aVisitId, aDate, aDoctor, aLocation,aDiagnosis, aTreatment, without Visit ID
	public VetVisitStandard(String theDate, String theDoctor, String theLocation, String vaccines, int License, String otherCare)
	{
		super(theDate, theDoctor, theLocation);
		this.setLicenseId(License);
		this.setVaccines(vaccines);
		this.setOtherCare(otherCare);
	}
	
	//pre: all of super's data, along with standard data
	//post: constructor with super and standard's arguments, with visit ID
	public VetVisitStandard(String theVisitId, String theDate, String theDoctor, String theLocation, String vaccines, int License, String otherCare)
	{
		super(theDate, theDoctor, theLocation);
		this.setLicenseId(License);
		this.setVaccines(vaccines);
		this.setOtherCare(otherCare);
		this.setVisitId(theVisitId);
	}
	
	//pre: String vaccines
	//post: sets vaccines
	public void setVaccines(String vaccines)
	{
		this.vaccines=vaccines;
	}
	
	//pre: int cityLicense
	//post: sets cityLicense
	public void setLicenseId(int licenseId)
	{
		this.licenseId=licenseId;
	}

	//pre: string otherCare
	//post: sets otherCare
	public void setOtherCare(String otherCare)
	{
		this.otherCare=otherCare;
	}
	
	//pre: n/a
	//post: returns vaccines
	public String getVaccines()
	{		
		return vaccines;
	}
	
	//pre:n/a
	//post: returns cityLicense
	public int getLicenseId()
	{
	
		return licenseId;
	}
	
	//pre: n/a
	//post: returns otherCare
	public String getOtherCare()
	{
		return otherCare;
	}
	
	//pre: n/a
	//post: returns super string appended on with Vaccines, Licenses, and other Care
	public String toString()
	{
		String blank=super.toString();
		String temp= blank + " Vaccine: "+ this.getVaccines()+ " License: "+this.getLicenseId()+ " Other Care: " +this.getOtherCare();
		return temp;
	}
	
}

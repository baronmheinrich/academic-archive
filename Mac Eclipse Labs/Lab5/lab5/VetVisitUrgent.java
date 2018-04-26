package lab5;

public class VetVisitUrgent extends VetVisit
{
	private String diagnosis;
	private String treatment;

	//pre: none
	//post// default super, default diagnosis and treatment
	public VetVisitUrgent()
	{
		super();
		this.setDiagnosis("**No Diagnosis**");
		this.setTreatment("**No Treatment**");
	}
	
	//pre: arguments from super, arguments from VetVisitUrgent
	//post: constructor with proper arguments
	public VetVisitUrgent(String theDate, String theDoctor, String theLocation, String diagnosis, String treatment)
	{
		super(theDate, theDoctor, theLocation);
		this.setDiagnosis(diagnosis);
		this.setTreatment(treatment);
	}

	//pre: diagnosis string
	//post: sets diagnosis
	public void setDiagnosis(String diagnosis)
	{
		this.diagnosis=diagnosis;
	}
	
	//pre: treatment String
	//post: sets treatment
	public void setTreatment(String treatment)
	{
		this.treatment=treatment;
	}
	
	//pre: n/a
	//post: returns treatment string
	public String getTreatment()
	{
		return treatment;
	}
	
	//pre: n/a
	//post: returns diagnosis string
	public String getDiagnosis()
	{
		return diagnosis;
	}
	
	//pre: n/a
	//post: returns appended string with super string followed by urgent's strings
	public String toString()
	{
		String blank=super.toString();
		String str=" Diagnosis: "+ this.getDiagnosis()+ " Treatment: "+ this.getTreatment();
		String temp=blank+str;
		return temp;
	}
}

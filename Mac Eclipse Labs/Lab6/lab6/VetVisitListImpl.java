package lab6;

import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class VetVisitListImpl implements VetVisitList {

	private int count;
	private Node<VetVisit>first;

	//pre: n/a
	//post: default constructor
	public VetVisitListImpl()
	{
		this.first=null;
		this.count=0;
	}
	
	//pre: n/a
	//post: returns count
	public int size()
	{
		return this.count;
	}

	@Override
	//pre: none
	// post: returns a String of all vet visits that occurred on given date
	public String getVetVisitListByDate(GregorianCalendar date) {
		//make a blank string
		//take string from argument and check all nodes
		//append found date to blank string
		//return blank string
		
		String blank="";
		for(Node<VetVisit> node=this.first; node!=null; node=node.link)
		{
			if(node.data.getDateCalendar().equals(date))
			//if(node.data.getDateCalendar()==date)
				blank=blank+node.data+"\n";
		}
		
		return blank;
	}

	//pre: VetVisit and visit
	//post: compares data and if it's the same it returns true, else returns false
	public boolean contains(VetVisit visit) {
		//compareTo date and chipId from visit data
		//if it equals 0 return true 

		Node<VetVisit>current=this.first;
		
		while(current!=null)
		{
			if(current.data.compareTo(visit)==0)
			{
				return true;
			}
			current=current.link;
		}

		return false;
	}

	//pre: VetVisit and vist
	//post: returns false if added visit exists, true if successfully added and increments count
	public boolean add(VetVisit visit) {
		//1. if already in the list return false
		//2. Find where to put it...
		//-must know where it is in the list, behind right node
		//get new node and put data into that node
		//connect the new node to the previous node
		//if previous value is null, connect first, otherwise connect at previous
		//increase count and return
		if(this.contains(visit))
		return false;
		
		Node<VetVisit>previous=null;
		Node<VetVisit>current=this.first;
		
		while(current!=null)
		{
			if(current.data.compareTo(visit)<0)
				break;
			previous=current;
			current=current.link;
		}
		Node<VetVisit>node=new Node<VetVisit>();
		node.data=visit;
		
		if(previous==null)
		{
			node.link=this.first;
			this.first=node;
		}
		else
		{
			node.link=previous.link;
			previous.link=node;
		}
		this.count++;
		return true;
	}

	//pre: VetVisit and visit
	//post: returns null if not found, returns visit if found and decrements count
	public VetVisit remove(VetVisit visit) 
	{
		//try to find visit in list, keep track of previous node and current node
		// if current is null, return null
		//if previous is null, disconnect the first node
		//disconnect previous if found, decrement count, and return data
		
		Node<VetVisit>previous=null;
		Node<VetVisit>current=this.first;
		
		while(current!=null)
		{
			if(current.data.compareTo(visit)==0)
				break;
			
			previous=current;
			current=current.link;

		}

		if(current==null)
		{
			return null;
		}
		
		if(previous==null)
		{
			this.first=this.first.link;
		}
		
		else
		{
			previous.link=current.link;
		}
		count --;
		return current.data;
		
		}
						
	//pre: n/a
	//post: sets count to 0 and first to null, clearing the list
	public void removeAll() 
	{
		this.first=null;
		this.count=0;
	}

	//pre:n/a
	//post: returns a string based the nodes 
	public String toString()
	{
		if(this.count==0)
		{
			String empty="Empty List";
			return empty;
		}
		String blank="";
		for(Node<VetVisit>node=this.first; node!=null; node=node.link)
		{
			blank=blank+node.data+"\n";
		}
		return blank;
	}
	
	//Add this method signature to your VetVisitList interface and its implementation to VetVisitListImpl
	//method in VetVisitList interface and its implementation
	//we need a way to write each VetVisit to the file properly and have no other method available to do so.
	//thus we are adding this method to the interface (so its available to use) and here is its implementation


	//pre:  out is opened and ready to write to
	//post: this list is written to out in 'readable' format  so output is same form as input file's visit list format
	public void writeToFile(PrintWriter out) {
			Node <VetVisit> node= this.first;
			while(node != null)
			{
				out.println(node.data.getDateString() + " " + node.data.getDoctor()+ "  " + node.data.getLocation());
				if(node.data instanceof VetVisitUrgent)
				{
					VetVisitUrgent visit = (VetVisitUrgent) node.data;
					out.println(visit.getDiagnosis());
					out.println(visit.getTreatment());
				}
				else
				{
					VetVisitStandard visit = (VetVisitStandard)node.data;
					out.println(visit.getVaccines());
					out.println(visit.getLicenseId() + "  " + visit.getOtherCare());
				}
				node = node.link;
			}//end while
			out.println("****");
		}
		  
	//note you will have to call the method above (writeToFile) inside the writeToFile for each HousePet.  Call the method
	//using the HousePet's visit list instance after you output the id, name, pet type and age.  
	//  ie:  this.visitList.writeToFile(out); 
	
}

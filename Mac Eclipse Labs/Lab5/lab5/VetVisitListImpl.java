package lab5;

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
	
}

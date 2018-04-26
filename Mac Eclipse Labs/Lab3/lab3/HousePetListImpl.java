package lab3;

import java.util.*;

public class HousePetListImpl implements HousePetList
{
	//private variables
	private HousePet list[];
	private int count;

	//pre: none
	//Post: blank constructor
	public HousePetListImpl()
	{
		this.list=new HousePet[HousePetList.MAX_SIZE];
		this.count=0;
	}

	//pre: none
	//Post: returns string of list array, returns empty list if blank
	public String toString()
	{
		String blank="";

		if(this.count==0)
		{
			blank="Empty List";	
			return blank;
		}

		else
			for(int i=0; i<this.count; i++)
			{
				blank+=this.list[i]+"\n";
			}
		return blank;
	}

	//pre: scanner in
	//post: tries to take data from scanner and place it in an array
	public void readFromScanner(Scanner inputSource)
	{
		HousePet pet=new HousePet();
		boolean result=pet.readFromScanner(inputSource);
		while(result==true && this.count<HousePetList.MAX_SIZE)
		{
			this.list[count]=pet;
			this.count ++;
			pet=new HousePet();
			result=pet.readFromScanner(inputSource);
		}
		this.sortByChipIdentifier();

	}

	//pre: none
	//post: sorts array by chip ID
	public void sortByChipIdentifier() 
	{
		{
			for(int i=0; i<count-1; i++)
			{
				int min=i;
				for(int k=i+1; k<count; k++)
				{

					if(this.list[k].compareTo(this.list[min])<0)
					{
						min=k;					
					}



				}
				HousePet temp=this.list[i];
				this.list[i]=this.list[min];
				this.list[min]=temp;
			}

		}
	}



	//pre: none
	//post: sorts list by name
	public void sortByName() 
	{
		for(int i=0; i<count-1; i++)
		{
			int min=i;
			for(int k=i+1; k<count; k++)
			{

				if(this.list[k].compareByName(this.list[min])<0)
				{
					min=k;					
				}



			}
			HousePet temp=this.list[i];
			this.list[i]=this.list[min];
			this.list[min]=temp;
		}

	}

	//pre: Housepet constructor and housepet object
	//post: Adds pet to the list, and reorganizes it
	//post: if list is full or pet already exists, doesn't add it to list
	public boolean add(HousePet housepet)
	{
		if(this.count>=HousePetList.MAX_SIZE)
			return false;

		if(this.contains(housepet))
			return false;

		this.list[this.count]=housepet;
		this.count++;
		this.sortByChipIdentifier();
		return true;
	}

	//pre: HousePet constructor and housepet object
	//post: searches for housepet, if not found returns null.  If successful, removes housepet from list, and reorganizes the list again.
	public HousePet remove(HousePet housepet) 
	{
	    int location=this.binSearch(housepet);
	    if(location==-1)
		return null;
	    
	    HousePet value=this.list[location];
	    this.list[location]=this.list[count-1];
	    count--;
	    
	    this.sortByChipIdentifier();
	    return value;
	}

	//pre: n/a
	//post: sets count to zero, clearing the array
	public void removeAll() 
	{
		this.count=0;
	}

	//pre: HousePet constructor and housepet object
	//post: returns false if the housepet is found, true if it isn't
	public boolean contains(HousePet housepet) 
	{
	    //sortByChipIdentifier called to double check list order
		this.sortByChipIdentifier();
		// returns true if housepet matches another housepet in the list
		// returns false if no match found ASSUMES HousePets are Comparable and
		// list is sorted always in ascending order
		if(binSearch(housepet)<0)
		{
			return false;
		}

		else
			return true;
	}

	//pre: n/a
	//post: returns number of elements in the list
	public int size() {
		// returns the current number of elements in the list

		int elements=0;
		for(int i=0; i<count; i++)
		{
			elements++;
		}
		return elements;
	}

	//pre: HousePet constructor and housepet object
	//post: returns values based on search results, -1 if not found at all
	private int binSearch(HousePet housepet)
	{
		int low=0;
		int high=this.count-1;

		while(low<=high)
		{
			int mid=(low+high)/2;
			int SearchValue=list[mid].compareTo(housepet);

			if(SearchValue==0)
				return mid;

			if(SearchValue>0)
				high=mid-1;

			else
				low=mid+1;

		}
		return -1;
	}

}
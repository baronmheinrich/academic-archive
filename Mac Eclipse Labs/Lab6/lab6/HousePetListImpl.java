package lab6;

import java.io.File;
import java.util.GregorianCalendar;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class HousePetListImpl implements HousePetList
{
	//private variables
	private HousePet list[];
	private int count;
	private boolean saved;


	//pre: none
	//Post: blank constructor
	public HousePetListImpl()
	{
		this.list=new HousePet[HousePetList.MAX_SIZE];
		this.count=0;
		this.saved=true;
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
			
			boolean add=this.add(pet);
			if(add==false){
				System.out.println("Duplicate Chip Id found:"+pet);
				System.out.println("Duplicate house pets not added to the list.");
			}
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
		{	
			return false;
		}

		if(this.contains(housepet))
		{
			return false;
		}
		this.list[this.count]=housepet;
		this.count++;
		this.sortByChipIdentifier();
		this.saved=false;
		return true;

	}

	//pre: HousePet constructor and housepet object
	//post: searches for housepet, if not found returns null.  If successful, removes housepet from list, and reorganizes the list again.
	public HousePet remove(HousePet housepet) 
	{
		int location=this.binSearch(housepet);
		if(location==-1)
		{
			return null;
		}

		HousePet value=this.list[location];
		this.list[location]=this.list[count-1];
		count--;
		this.saved=false;
		this.sortByChipIdentifier();
		return value;
	}

	//pre: n/a
	//post: sets count to zero, clearing the array		this.saved=true;
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
	public int size()
	{
		// returns the current number of elements in the list
		return this.count;
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

	//pre: housepet name string
	//post: returns string of housepet data, returns blank string if no housepet found
	public String getHousePetsByName(String housePetName) 
	{
		String petName="";
		for(int i=0; i<this.count; i++)
		{
			String str=this.list[i].getName();
			if(housePetName.compareToIgnoreCase(str)==0)
			{
				petName=petName+this.list[i]+"\n";
			}
		}

		return petName;
	}


	//pre: chipIdNumber and NewAge
	//post: modifies age based on given chipId and age, alters saved boolean and returns true
	public boolean modifyAge(int theChipIdNumber, double newAge) 
	{
		//don't forget to modify 'saved' boolean!!
		HousePet housepet=new HousePet();
		housepet.setChipId(theChipIdNumber);
		if(newAge<0)
			return false;

		int location=this.binSearch(housepet);
		if(location==-1)
		{
			return false;
		}

		else{
			this.list[location].setAge(newAge);
			this.saved=false;
			return true;
		}

	}

	//pre: string with filename
	//post: creates new file based on filename, returns false if file cannot be made
	public boolean saveToFile(String filename) 
	{
		PrintWriter outFile=null;

		try
		{
			outFile=new PrintWriter(new File(filename));
			for(int i=0; i<this.count; i++)
			{
				this.list[i].writeToFile(outFile);
			}
			outFile.close();
			this.saved=true;
			return true;

		} 
		catch (FileNotFoundException e) 
		{

			return false;
		}
	}


	// pre: none
	// post: returns true if the current list has been saved, false if list has been modified
	public boolean isSaved() 
	{
		return saved;
	}

	//chip id and vetvisit
	//returns true if successfully added, false if not
	public boolean addVetVisit(int chipId, VetVisit visit) 
	{
	
		
		HousePet housepet=new HousePet();
		housepet.setChipId(chipId);
		int location=binSearch(housepet);
		
		if(location==-1)
		{
			return false;
		}
		
		VetVisitList aList=list[location].getVisitList();
			boolean result=aList.add(visit);
			this.saved=false;
			return result;
		//find new housepet with ID and construct new housepet
		//if not found return false
		//if found get VisitList at that location
			//aList=list[location].getVisitList();
		//boolean result=aList.add(visit);
		//return result
		
	}

	//pre:chipId and vetvisit vist
	//post: removes vetvisit from chipId and returns the result and sends the removed visit to an outfile
	public VetVisit removeVetVisit(int chipId, VetVisit visit) 
	{
		//VetVisit removeVisit=aList.remove(visit)
		//if removed, add to cancel.txt, append it, and close the document
		//return removeVisit
		HousePet housepet=new HousePet();
		housepet.setChipId(chipId);
		int location=binSearch(housepet);
		
		if(location==-1)
		{
			return null;
		}
		VetVisitList aList=list[location].getVisitList();
		VetVisit result = aList.remove(visit);
		if(result==null)
		{
			return null;
		}
		
		PrintWriter outFile=null;

		try
		{
			outFile = new PrintWriter(new FileWriter("cancel.txt", true));
			outFile.println("removed visit from chip Id: " + chipId);
			GregorianCalendar today = new GregorianCalendar(); 
			outFile.println(MyUtils.dateToString(today) + "     " + result);
			outFile.close();

		} 
		catch(FileNotFoundException e){

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.saved=false;
		return result;
		
		
		
	
	}


}
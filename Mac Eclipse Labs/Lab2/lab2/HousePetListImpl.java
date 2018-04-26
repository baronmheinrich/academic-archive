package lab2;

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
		/*
		for(int i=1; i<count; i++)
		{
			int k=i;
				while(k<0)
				{
					if(list[k].getChipId().compareTo(list[k-1].getChipId())<0)
					{
						HousePet temp=list[k];
						list[k]=list[k-1];
						list[k-1]=temp;
						k--;
					}
					else
					{
						k=0;
					}
				}
		}
		*/
	

	
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
}
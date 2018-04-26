/**
   HousePetList interface
   used to describe methods useful with a list of HousePet instances
   January 21, 2014
   cosc 2125
 */

package lab4;

import java.util.Scanner;

public interface HousePetList
{
	public static final int MAX_SIZE = 30; // max number of items in list
	public void readFromScanner(Scanner inputSource);
	// populates this list from inputSource until full or inputSource is exhausted
	// makes sure that list is sorted always in ascending order
	public void sortByChipIdentifier();
	// sorts the list by account number
	public void sortByName();
	// sorts the list by name, if 2 names match, break tie on account number field
	public boolean add(HousePet housepet);
	// tries to add housepet to list if room and not already in the list
	// returns true on successful add, false if unable to add
	// keeps list sorted in ascending order, assumes Comparable is implemented for
	// HousePet instances
	public HousePet remove(HousePet housepet);
	// tries to find and remove housepet from the list, if found 
	//  removes and returns that housepet from the list.
	//  assumes list is sorted in ascending order always using Comparable interface
	// if not found, returns null.
	public void removeAll();
	// removes ALL housepets
	public boolean contains(HousePet housepet);
	// returns true if housepet matches another housepet in the list
	// returns false if no match found ASSUMES HousePets are Comparable and
	// list is sorted always in ascending order
	public int size();
	// returns the current number of elements in the list+
	
	  // returns a String containing a  list of all housepets that 
    // have the given name, case insensitive
    // returns empty string if NO housepets match with given housePetName
    // (make sure you fix or solve the upper/lowercase string compare problem.)
   public String getHousePetsByName(String housePetName);

   // tries to find housepet with given chip id number, if found modifies age
   // to given newAge
   // if not found no changes made, returns false
   // pre: newAge >= 0
   // post: if theChipId matches housepet in current list, modify
   // age of that housepet to given newAge, returns true.  
   // If newAge < 0 returns false.
   public boolean  modifyAge(int theChipIdNumber, double newAge);

   // pre: receives a filename to save current list out to
   //      filename is a valid system filename 
   // post: writes current list to file with given filename.  Overwrites file
   //       with filename if that file currently exists, if not, creates file.
   // returns: true if list is saved to file, false if cannot write to file or any such output problem
   public boolean saveToFile(String filename);
  
   // pre: none
   // post: returns true if the current list has been saved, false if list has been modified since last saved
   public boolean isSaved();
}
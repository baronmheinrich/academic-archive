/**
   HousePetList interface
   used to describe methods useful with a list of HousePet instances
   January 21, 2014
   cosc 2125
 */

package lab3;

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
	// returns the current number of elements in the list
}
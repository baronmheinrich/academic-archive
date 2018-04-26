package lab3;
/** cosc 2125 lab #2 test file
 * date: January 21, 2014
 * tests interface HousePetList
 * assumes housepet.txt data file is available for use
 * outputs to screen list of house pets from data file
 *
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HousePetListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		HousePetList myList = new HousePetListImpl();
		Scanner inputSource = null;
		try {
			inputSource = new Scanner(new File("housepet.txt"));
		}catch (FileNotFoundException e) {
			System.out.println("error, cannot open file 'housepet.txt'," +
					" NOT FOUND, no data read");
			return;
		}
		myList.readFromScanner(inputSource);
		System.out.println("Current list of House Pets from input: \n" + myList);
		myList.sortByChipIdentifier();
		System.out.println("House Pets sorted by Chip Identifier \n" + myList);
		myList.sortByName();
		System.out.println("House Pets sorted by Name \n" + myList); 
		System.out.println("Now working with an empty list");
		HousePetList myList2 = new HousePetListImpl();
		System.out.println("Current list of House Pets (should be empty) \n" + myList2);
		myList2.sortByChipIdentifier();
		System.out.println("House Pets sorted by Chip Identifier (should be empty) \n" 
				+ myList2);
		myList2.sortByName();
		System.out.println("House Pets sorted by Name (should be empty) \n" + myList2); 



	}

}
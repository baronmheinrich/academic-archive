package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//the test class for the menu driven program
public class Lab3MenuTest
{
	// the main method that starts everything
	public static void main(String args[] )
	{
		// create a list of HousePet objects
		HousePetList myList = new HousePetListImpl();  

		char option = '$';
		do
		{
			displayMenuToUser(); // show menu options to user 
			option = getUserSelection();  // get user's option
			switch(option)
			{
			case 'a': populateList(myList);
			break;
			case 'b': menuAdd(myList);
			break;
			case 'c': menuRemove(myList);
			break;
			case 'd': removeAll(myList);
			break;
			case 'e':viewList(myList);
			break;
			case 'f': menuSearch(myList);
			break;
			case 'g': listSize(myList);
			break;
			case 'h': exitMessage();
			} // end switch
		}
		while( option !='h') ;
	} // end main

	//pre:n/a
	//post: displays menu options to the user
	public static void displayMenuToUser() 
	{
		/*  a) populate list from user supplied data file
	   b) add account to the list
	   c) remove account from the list
	   d) remove all accounts from the list
	   e) view the current list
	   f) check if an account is in the list
	   g) get the size of the list
	   h) quit */
		System.out.println("Welcome to the Rad Pet List Storter!  Pick a command: \n");
		System.out.println("a) Populate data from your own list... ");
		System.out.println("b) Add a pet to the list... ");
		System.out.println("c) Remove a pet from the list... ");
		System.out.println("d) Remove all pets from the list... ");
		System.out.println("e) view the list... ");
		System.out.println("f) check if a pet is in the list... ");
		System.out.println("g) check the size of the list... ");
		System.out.println("h) quit the rad pet list sorter");
	}
	
	//pre: HousePetList and myList
	//post: populates list from user supplied file if successful, returns error message otherwise
	public static void populateList(HousePetList myList) 
	{
		Scanner console=new Scanner(System.in);
		System.out.println("Please enter a file name:");
		String fileName=console.nextLine();

		try {
			Scanner input = new Scanner(new File(fileName));
			myList.readFromScanner(input);
			System.out.println("File Added! \n");
		}catch (FileNotFoundException e) {
			System.out.println("error, cannot open file." +
					" NOT FOUND, no data can be read");
		}
	}

	//pre: n/a
	//post: returns the user choice
	public static char getUserSelection ()
	{  
		char choice;
		String answer; // holds the user's selection
		Scanner input = new Scanner (System.in);

		do {
			System.out.print("Enter your selection: ");
			answer = input.nextLine();
			choice = Character.toLowerCase(answer.charAt(0));
		} while ( choice !='h' && choice !='a' && choice !='b' &&
				choice !='c' && choice !='d' && choice !='e' && choice !='f' && choice !='g'); 
		// assuming a-h are good and h is quit (modify as needed for options) 
		return choice;
	} 

	//pre: HousePetList and myList
	//post: returns a message if the pet was added successfully
	public static void menuAdd(HousePetList myList)
	{
		Scanner input = new Scanner(System.in);
		HousePet housepet = new HousePet(); 
		// create object to be added
		System.out.println("enter data for your house pet, return at each entry: (ID, Name, Type, Age...)");
		housepet.readFromScanner(input);  //  read in data for Account
		boolean result = myList.add(housepet);  // call the add method of add
		if (result) // if we got back a true from add
			System.out.println(housepet + "\nYour pet was added successfully to the list! \n");
		else
			System.out.println(housepet + "\nYour pet was NOT added to the list... \n");
		return;
	} // end MenuAdd

	/** prompts the user for a menu selection
  reads and verifies selection, returns only
  a valid selection, loops until a valid selection is given
 @return - the valid selection as input
	 */

	//pre: HousePetList and myList
	//post: returns successful or failed message at removing the pet from the list
	public static void menuRemove(HousePetList myList) 
	{
		Scanner console=new Scanner(System.in);
		HousePet housepet = new HousePet();

		System.out.println("Please select a house pet you'd like to remove, return at each entry: (ID, Name, Type, Age)");
		housepet.readFromScanner(console);

		if(myList.remove(housepet)==null)
			System.out.println("The selected house pet was not removed. \n");
		else
			System.out.println("The selected house pet was successfully removed. \n");

	}

	//pre: HousePetList and myList
	//post: calls method to set count to 0
	public static void removeAll(HousePetList myList) 
	{
		myList.removeAll();
		System.out.println("List cleared \n");
	}

	//pre: HousePetList myList
	//post: displays current list
	public static void viewList(HousePetList myList) 
	{
		System.out.println("Your list is as follows...\n");
		System.out.println(myList);
	}

	//pre: HousePetList and myList
	//Post: searches list and returns a message with the results
	public static void menuSearch(HousePetList myList) 
	{
		//fix menu list
		Scanner console=new Scanner(System.in);
		HousePet housepet = new HousePet(); 

		System.out.println("Please enter a house pet you want to search, return at each entry: (ID, Name, Type, Age)");
		housepet.readFromScanner(console);
		boolean result=myList.contains(housepet);

		if(result==false)
			System.out.println("That pet is not in the list... \n");
		else
			System.out.println("That pet is in the list!\n");


	}


	//pre: HousePetList and myList
	//post: returns a message with the size of the list
	public static void listSize(HousePetList myList)
	{
		int size=myList.size();
		System.out.println("The size of your list is: "+ size+ "\n");
		// TODO Auto-generated method stub

	}


	//pre: n/a
	//post: terminates the program
	public static void exitMessage()
	{
		System.out.println("Program Terminated");
	}

} // end MenuTest class










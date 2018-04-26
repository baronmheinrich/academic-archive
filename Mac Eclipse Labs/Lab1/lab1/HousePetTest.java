/** @author Baron Heinrich
    A test class for the HousePet class.
    Assumes HousePet exists in the package lab1
    Tests constructors, accessors, modifiers, toString in HousePet
*/

package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HousePetTest {

	/**
	 * @param args-command line arguments, none expected
	 */
	public static void main(String[] args) {
	    HousePet hp1 = new HousePet();
	    HousePet hp2 = new HousePet(4566, "Susie", "dog", 3.67);
	    HousePet hp3 = new HousePet(-1, "", "", -1.0);

	    System.out.println("Just created 3 house pets: \n" +
	                        "First HousePet: " + hp1 + "\n"  +
	                        "Second HousePet: " + hp2 + "\n" + 
	                        "Third HousePet: " + hp3 + "\n");
	    System.out.println("Now testing mutators on HousePet hp1: \n");
	    hp1.setName("Sport");
	    hp1.setChipId(111);
	    hp1.setAge(0.5);
	    hp1.setPetType("Dog");
	    System.out.println("Here is hp1 (should be: 111, Sport, dog, 0.5) \n"+ hp1);
	    System.out.println("Now testing accessors");
	    System.out.println(" hp1 name: " + hp1.getName() + 
	                       " hp1 chipId: " + hp1.getChipId() +
	                       " hp1 age: " + hp1.getAge() +
	                       " hp1 pet type: " + hp1.getPetType());
	    hp2.setName("Silly Kitty");
	    hp2.setChipId(-999);
	    hp2.setAge(-1.0);
	    hp2.setPetType("cat");
	    System.out.println("Here is modified HousePet hp2 " + 
	                       " after setting using values (-999, Silly Kitty, cat, -1.0)\n" + hp2);
	    System.out.println("Now testing accessors on HousePet hp2");
	    System.out.println("name: " + hp2.getName() + "  chipId: " + hp2.getChipId() +
	                       "  age: " + hp2.getAge()  +
	                       " pet type: " + hp2.getPetType());
	    hp3.setName("Quacker Backer");
	    hp3.setChipId(11199);
	    hp3.setAge(2.5);
	    hp3.setPetType("Duck");
	    System.out.println("Here is modified HousePet hp3 changed to " +
	                       " (id-11199, age - 2.5, name-Quacker Backer, pet type: Duck\n" + 
	                       hp3);
	    System.out.println("Now testing accessors on HousePet hp3");
	    System.out.println("name: " + hp3.getName() + "  chip Id: " + hp3.getChipId() +
	                       " age: " + hp3.getAge()  +
	                       " pet type: " + hp3.getPetType());

	    System.out.println("Now testing the readFromScanner method...");
	    Scanner input = new Scanner(System.in);
	    System.out.print(" Please enter data for your pet, 1 item per line " + 
	                     "Chip Id <enter> name <enter> pet type <enter> age <enter> ");
	    HousePet hp6 = new HousePet();
	    hp6.readFromScanner(input);
	    System.out.println("Here is the house pet's data just read: \n" + hp6);
	    
	    System.out.println("Now testing invalid data, setting " +
			       " last pet to Joe");
	    hp6.setName("Some Bad House Pet Data");
	    hp6.setChipId(-2);
	    hp6.setAge(-2.0);
	    hp6.setPetType("Silly Pet");
	    System.out.println("Here is the house pet with invalid data \n" + hp6);
	    System.out.println("Now reading HousePets from a data file");
	    System.out.println("Attempting to open file, 'housepet.txt'");
	    Scanner infile = null;
	    String filename = "housepet.txt";
	    try {
	    	 infile = new Scanner (new File (filename));
	    }catch(FileNotFoundException e)
	    {
	    	System.out.println("Error trying to read input file, " + filename + " now exiting...");
	    	System.exit(0);
	    }
	    HousePet hp7 = new HousePet();
	    while(infile.hasNext())
	    {
	    	hp7.readFromScanner(infile);
	    	System.out.println("just read pet data: " + hp7 + " from file. ");
	    }
	    System.out.println("found end of file...done reading.");
	    System.out.println("*** End of HousePetTest ***");	
	    }
		
	}


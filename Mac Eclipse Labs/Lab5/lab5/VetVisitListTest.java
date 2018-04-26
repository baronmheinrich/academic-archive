package lab5;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class VetVisitListTest {
    VetVisit visit1 = new VetVisitUrgent("12/23/2013","Dr. J.", "Animal Care Clinic", "stomach illness", "rest and food");
    VetVisit visit2 = new VetVisitUrgent("1/3/2014", "Dr. Greene", "Emergency Vet Clinic", "vertigo", "prescription");
    VetVisit visit3 = new VetVisitStandard("2/12/2012", "Dr. House", "Animal Care Clinic", "rabies", 4325, "rymadyl as needed.");
    VetVisit visit4 = new VetVisitStandard("5/3/2010", "Dr. Blagg", "Vet Care Hospital", "rabies, parvo", 1127, "No other care.");
    VetVisit visit5 = new VetVisitUrgent("5/3/2010", "Dr. Blagg", "Vet Care Hospital", "illness", "rest");
    VetVisit visit6 = new VetVisitStandard("12/23/2013", "Dr. Blagg", "Vet Care Hospital", "rabies, parvo", 1127, "No other care.");
    VetVisitList myList = new VetVisitListImpl();
    
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		System.out.println("visit 1 = \n" + visit1);
		//VetVisitList myList = new VetVisitUrgentListImpl();
		myList.add(visit1);
		assertTrue(myList.size() == 1);
		assertTrue(myList.contains(visit1));
		System.out.println("here is the list : \n" +myList);
		myList.add(visit2);
		assertTrue(myList.size() == 2);
		assertTrue(myList.contains(visit2));
		System.out.println("here is the list : \n" +myList);
		myList.add(visit3);
		assertTrue(myList.size() == 3);
		assertTrue(myList.contains(visit3));
		System.out.println("here is the list : \n" +myList);
		myList.add(visit4);
		assertTrue(myList.size() == 4);
		myList.add(visit5);
		assertTrue(myList.size() == 5);
		myList.add(visit5);
		assertTrue(myList.size() == 5);
		myList.add(visit6);
		assertTrue(myList.size() == 6);
		GregorianCalendar date=new GregorianCalendar(2010,4,3);
		String result = myList.getVetVisitListByDate(date);
		assertFalse(result.equals(""));
		System.out.println("current list for " + MyUtils.dateToString(date)+"\n"
				           + result);
		date=new GregorianCalendar(2013,11,23);
		result = myList.getVetVisitListByDate(date);
		assertFalse(result.equals(""));
		System.out.println("current list for " + MyUtils.dateToString(date)+"\n"
				           + result);
	 	date=new GregorianCalendar(2014,0,3);	
	 	result = myList.getVetVisitListByDate(date);
	 	assertFalse(result.equals(""));
	 	System.out.println("current list for " + MyUtils.dateToString(date)+"\n"
								           + result);
	 	date=new GregorianCalendar(2014,3,3);	
	 	result = myList.getVetVisitListByDate(date);
	 	assertTrue(result.equals(""));
	 	System.out.println("current list for " + MyUtils.dateToString(date)+"\n"
								           + result);
	 	date=new GregorianCalendar(2009,10,24);	
	 	result = myList.getVetVisitListByDate(date);
	 	assertTrue(result.equals(""));
	 	System.out.println("current list for " + MyUtils.dateToString(date)+"\n"
								           + result);
		
		
		System.out.println("here is the list : \n" +myList);
		assertTrue(myList.contains(visit1));
		assertTrue(myList.contains(visit2));
		assertTrue(myList.contains(visit3));
		assertTrue(myList.contains(visit4));
		System.out.println("here is the list: \n" +myList);
        VetVisit removed = myList.remove(visit1);
        System.out.println("just removed " + removed);
        assertFalse(myList.contains(visit1));
        assertTrue(myList.size()==5);
        myList.remove(visit2);
        assertFalse(myList.contains(visit2));
        assertTrue(myList.size()==4);
        myList.remove(visit3);
        assertFalse(myList.contains(visit3));
        assertTrue(myList.size()==3);
        myList.remove(visit4);
        assertFalse(myList.contains(visit4));
        assertTrue(myList.size()==2);
        myList.add(visit1);
        assertTrue(myList.size()==3);
        myList.removeAll();
        assertTrue(myList.size()==0);
        myList.add(visit4);
        myList.add(visit3);
        assertTrue(myList.size() == 2);
        assertTrue(myList.contains(visit4));
        assertTrue(myList.contains(visit3));
        assertFalse(myList.contains(visit1));
        assertFalse(myList.contains(visit2));
        System.out.println("List of 2 :\n" + myList);
        
        
        
		assertTrue(myList.remove(visit1) == null);
		assertFalse(myList.contains(visit1));
		assertTrue(myList.remove(visit4) != null);
		assertFalse(myList.contains(visit4));
		assertTrue(myList.size() == 1);
		assertTrue(myList.remove(visit4) == null);
		assertTrue(myList.add(visit2));
		assertFalse(myList.add(visit3));
		assertTrue(myList.remove(visit3)!=null);
		assertTrue(myList.remove(visit2) != null);
		assertTrue(myList.size() == 0);
		assertTrue(myList.add(visit4));
		assertTrue(myList.add(visit2));
		assertTrue(myList.contains(visit4));
		assertTrue(myList.contains(visit2));
		assertFalse(myList.contains(visit3));
		System.out.println("here is the list: \n" +myList);
		assertTrue(myList.size() == 2);
		VetVisitUrgent visit5 = new VetVisitUrgent();
		myList.add(visit5);
		assertTrue(myList.contains(visit5));
		assertTrue(myList.size() == 3);
		System.out.println("here is the list with a default urgent: \n"+myList);
		VetVisitStandard visit6 = new VetVisitStandard();
		myList.add(visit6);
		assertTrue(myList.contains(visit6));
		assertTrue(myList.size() == 4);
		System.out.println("here is final list with a default standard: \n"+myList);
		
		
		
	}

}

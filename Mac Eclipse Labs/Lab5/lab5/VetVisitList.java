package lab5;

import java.util.GregorianCalendar;

public interface VetVisitList
{
  //pre: none
  // post: returns number visits in the list
  public int size();  
  //pre: none
  // post: returns a String of all vet visits that occurred on given date
  public String getVetVisitListByDate(GregorianCalendar date);
  //pre: none
  //post: returns true if the list contains given VetVisit false if not in list.
  public boolean contains(VetVisit visit);
  // pre: none
  // post: adds vet visit to list if not in list already returns true if added, false if not
  //      list remains sorted by date at all times (most recent to least recent)
  public boolean add(VetVisit visit);
  // pre: none
  // post: returns vet visit  in list that matches given vet visit, removes it from list
  //       list remains sorted by date after removal. (most recent to least recent)
  public VetVisit remove(VetVisit visit);
  //pre: none
  // post: all vet visits removed from list
  public void removeAll();
  //pre: input is open and ready to read a list of zero or more VetVisit sets of data
  //post: input has been exhausted and stored into this list 
}
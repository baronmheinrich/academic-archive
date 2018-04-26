package lab2;

import java.util.Scanner;

public interface HousePetList {
	public static final int MAX_SIZE = 30;
	  public void readFromScanner(Scanner inputSource);
	  public void sortByChipIdentifier();
	  public void sortByName();
}

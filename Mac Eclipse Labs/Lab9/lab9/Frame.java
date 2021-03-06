package lab9;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Frame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int FRAMEHEIGHT=1500;
	public static final int FRAMEWIDTH=1500;
	JButton reset = new JButton("Reset");
	JButton start = new JButton ("Start");
	JButton stop = new JButton ("Stop");

	MyPanel panel = null;  // the panel we are drawing on
	boolean stopflag=false; // helps to control the threads, set to true to stop process
	int speed=400; //default speed
	Thread sortThread=null;
	int min=0;
	int max=0;
	int choice=0;

	//default constructor for array
	int array[];
	Random ran=new Random();


	ButtonGroup myButtons = new ButtonGroup();
	ButtonGroup myOtherButtons=new ButtonGroup();
	JRadioButton speed1 = new JRadioButton("Slow");
	JRadioButton speed2 = new JRadioButton("Medium");
	JRadioButton speed3 = new JRadioButton("Fast");
	JRadioButton merge = new JRadioButton("Marge Sort");
	JRadioButton insertion = new JRadioButton("Insertion Sort");
	JRadioButton quick = new JRadioButton("Quick Sort");


	//pre:n/a
	//post: frame constructor
	public Frame()
	{

		//populate list when program starts
		//Constructs random array at launch
		array=new int[500];
		populateList(array);
		panel=new MyPanel(array);



		// set all of the widgets (buttons etc.) onto the frame
		this.setTitle("Sorting Algorithms");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(start); 
		this.getContentPane().add(stop); 
		this.getContentPane().add(reset); 

		// now add each button to the frame's content pane
		this.getContentPane().add(speed1);
		this.getContentPane().add(speed2);   
		this.getContentPane().add(speed3);

		this.getContentPane().add(merge);
		this.getContentPane().add(insertion);   
		this.getContentPane().add(quick);

		this.getContentPane().add(panel);


		// now put the speed buttons into a group so only 1 can be "on"
		this.myButtons.add(speed1);
		this.myButtons.add(speed2);
		this.myButtons.add(speed3);

		//other set of buttons that control speed.  Only one can be on at a time
		this.myOtherButtons.add(merge);
		this.myOtherButtons.add(insertion);
		this.myOtherButtons.add(quick);


		//Automatically selects radio button
		merge.setSelected(true);
		speed1.setSelected(true);


		speed1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speed=50;
			}});

		speed2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speed=30;
			}});

		speed3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speed=10;
			}});



		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sortThread != null)
				{  
					stopflag=true;
				}
				sortThread = new Thread(new Runnable() {
					public void run()
					{
						resetArray(array);  
						stopflag=false;


						//if statements run processes based on selection
						if(merge.isSelected())
						{
							//call merge method
							mergeSort(array,0, array.length-1);
						}
						if(insertion.isSelected())
						{
							insertionSort(array);
						}
						if(quick.isSelected())
						{
							//call quick sort method
							quickSort(array, 0, array.length-1);
						}
					} // end of run
				}); // end of creating a new Thread hrunner
				sortThread.start(); // add the Thread to the process queue
			}});


		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopflag = true; 
			}});


		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopflag=true;
				resetArray(array);
			}});
	}

	//pre: int list[]
	//post: populates list[] with random integers
	public void populateList(int list[])
	{
		Random ran=new Random();

		for(int i=0; i<list.length && stopflag==false; i++)
		{
			list[i]=ran.nextInt(500)+1;
		}
	}

	//pre: int list[]
	//post: shuffles array with random integers from array
	public void resetArray(int list[])
	{
		//for loop array and pick a random index location with current location at i and swap location
		Random ran=new Random();

		for(int i=0; i<list.length; i++)
		{
			int temp=list[ran.nextInt(500)];
			list[i]=temp;
		}
		repaint();
	}

	//start of quicksort
	//pre: list array, lowest value, highest value
	//post: partitions the array for quicksort method
	public int partition ( int list[], int lo, int hi)
	/* given:  list, the array to be partitioned
	           lo and hi, the index limits of the list to partition
	           pivot - location at which partition takes place.
	   task:  partition the array between lo and hi, returning location
	          of the partition in variable pivot.

	   returns:  list partitioned and pivot as location of partition */
	{
	  int  pivotvalue;  // type of element being sorted


	  pivotvalue = list[lo];
	  while( lo < hi)
	  {
	     while (lo < hi && pivotvalue < list[hi] && stopflag==false) 
	       hi--;
	     if (lo != hi)
	      {
	       list[lo]=list[hi];
	       lo++;
			try
			{
				Thread.sleep(speed);
			}catch(InterruptedException e)
			{
				System.out.println(e);
			}

			repaint();
	      }
	     while (lo < hi && pivotvalue > list[lo] && stopflag==false)
	       lo++;
	     if (lo !=hi)
	      {
	       list[hi]= list[lo];
	       hi--;
			try
			{
				Thread.sleep(speed);
			}catch(InterruptedException e)
			{
				System.out.println(e);
			}

			repaint();
	       }
	   }  // end of while 
	 list[hi]=pivotvalue;
	 return hi;  // index of partition
	}

	//pre: list [], low value, high value
	//post: organizes list 
	public void quickSort(int [] list, int lower, int upper)
	/* given:  array list with indices lower and upper 
	   task:   to sort array list from lower to upper
	   returns:  array list sorted */
	{
	 int pivotlocation ;

	  if (lower < upper && stopflag==false)  //  is a list of more than 1 to sort?
	   {
	    pivotlocation=partition(list, lower,upper);
	    quickSort(list, lower, pivotlocation-1);
	    quickSort(list, pivotlocation+1, upper);
		try
		{
			Thread.sleep(speed);
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}

		repaint();
	   }    
	 }
	// end of  quickSort
	


	//start of merge sort

	//pre: takes in myList[], low int, high int
	//post: splits list in two and calls itself
	 public void mergeSort(int myList[], int low, int high)
	 { // mergesorts myList [low:high]
	   int mid;

	   if (low < high && stopflag==false)  // are there at least 2 values to sort?
	   {
	    mid = (low+high)/2;
	    mergeSort(myList, low, mid);    // sort lower half
	    mergeSort(myList, mid+1, high);  // sort upper half
	    merge(myList, low,mid,mid+1,high);  // merge 2 halves
	   
		try
		{
			Thread.sleep(speed);
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}

		repaint();
	   }
	 }

	 //pre: myList, lowest value in split array, mid value from split array, low value from second split and high value from second split
	 //post: organizes list
	public void  merge( int myList[],int low, int mid, int low1,int high) {
		// merges two sorted lists within myList,
		//    myList[low:mid] and myList[low1:high]

		int temp[] = new int [(mid-low+1)+(high-low1+1)];
		// temp to hold list as merged.
		int s1, s2, d, k;  // indexes used to keep track of positions in merging
		s1=low;            // start of lower half, s1, upper half start is s2
		s2=low1;
		d=0;
		while(s1<=mid && s2<=high && stopflag==false)  // while elements in BOTH sublists left
		{
			if(myList[s1] < myList[s2])
				temp[d++] = myList[s1++];
			else
				temp[d++] = myList[s2++];
			try
			{
				Thread.sleep(speed);
			}catch(InterruptedException e)
			{
				System.out.println(e);
			}

				repaint();
		}
		while (s1<=mid && stopflag==false)       // while lower half is not merged, copy rest of it
		{  temp[d++]=myList[s1++];

		try
		{
			Thread.sleep(speed);
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}

			repaint();
		
		}
		while (s2<=high && stopflag==false)      // while upper half is not merged copy rest into temp
		{  temp[d++]=myList[s2++];
		}

		for(k=0,s1=low;s1<=high; s1++,k++)  // now copy temp BACK to myList
			myList[s1]=temp[k];
		try
		{
			Thread.sleep(speed);
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}

			repaint();
		
	}   

	//end of merge sort


	//start of insertion sort
	//pre: array
	//post: sorted list
	public void insertionSort(int list[])
	{
		for(int i=1; i<list.length && stopflag==false; i++)
		{
			int k=i;
			while(k>0 && stopflag==false)
			{
				if(list[k]<list[k-1])
				{
					int temp=list[k];
					list[k]=list[k-1];
					list[k-1]=temp;
					k--;

				}
				else
				{
					k=0;
				}


				try
				{
					Thread.sleep(speed);
				}catch(InterruptedException e)
				{
					System.out.println(e);
				}

				repaint();
			}
		}
	}
	//end of insertion sort

	//pre: n/a
	//post: customized list
	private static void createAndShowGUI() {
		//Make sure we have nice window decorations.
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			JFrame.setDefaultLookAndFeelDecorated(true);    
		}
		catch (ClassNotFoundException e) {
			JFrame.setDefaultLookAndFeelDecorated(true);    
		}
		catch (InstantiationException e) {
			JFrame.setDefaultLookAndFeelDecorated(true);    
		}
		catch (IllegalAccessException e) {
			// handle exception
		}

		//Create and set up the window.
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}

	//pre:n/a
	//post: main method
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	
	class MyPanel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static final int MYWIDTH=500;
		public static final int MYHEIGHT=500;
		private int myList[];

		//pre: array
		//post: sets dimensions and myList gets array from above
		MyPanel(int array[])
		{
			this.setPreferredSize(new Dimension(MYWIDTH,MYHEIGHT));
			myList=array;

		}

		//pre: Graphics g
		//post: paints MyPanel and calls drawLines to paint
		public void paintComponent(Graphics g)
		{ 
			super.paintComponent(g); // always paint the parent!
			drawLines(g);

		}
		
		//pre: Graphics g
		//post: paints lines based off of array
		public void drawLines(Graphics g)
		{
			for(int i=0; i<myList.length;i++)
			{
				g.drawLine(i, MYHEIGHT, i, MYHEIGHT-myList[i]);
			}
		}

	}

}
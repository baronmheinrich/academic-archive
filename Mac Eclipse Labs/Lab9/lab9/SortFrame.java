package lab9;

/**
 * @author Laura Baker
 * @version 1.1
 * program to demonstrate the Towers of Hanoi using
 * graphics w/Frame and threads
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


@SuppressWarnings("serial")
public class SortFrame extends JFrame 
{
	/** these are all of the widgets (parts) that go on the Frame
	 *  Buttons for execution control, radioButtons for speed control
	 *  a Panel to paint the towers in
	 */

	public static final int FRAMEHEIGHT=1000;
	public static final int FRAMEWIDTH=1000;
	JButton reset = new JButton("Reset");
	JButton start = new JButton ("Start");
	JButton stop = new JButton ("Stop");

	Thread hrunner;  // the process running Hanoi method
	int list[]= null;
	Thread stortThread=null;
	MyPanel panel = new MyPanel(list);  // the panel we are drawing on
	boolean stopflag=true;         // helps to control the threads



	ButtonGroup myButtons = new ButtonGroup();
	JRadioButton speed1 = new JRadioButton("Slow");
	JRadioButton speed2 = new JRadioButton("Medium");
	JRadioButton speed3 = new JRadioButton("Fast");



	int progspeed = 250;
	// the 3 towers (plain old fashioned stacks ) 
	/*StackV<Integer> t1 = new StackV<Integer>();
	StackV <Integer>t2 = new StackV <Integer>();
	StackV <Integer>t3 = new StackV <Integer>();

	/** our Constructor with a title for the frame
	 *  this creates the entire "frame" with all of its components
	 * @param title - value to print on the frame title bar
	 */ 

	public SortFrame()
	{
		this.list=new int[500];

		//populate list when program starts


		// set all of the widgets (buttons etc.) onto the frame
		this.setTitle("The Towers of Hanoi");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(start); 
		this.getContentPane().add(stop); 
		this.getContentPane().add(reset); 

		// now put the speed buttons into a group so only 1 can be "on"
		this.myButtons.add(speed1);
		this.myButtons.add(speed2);
		this.myButtons.add(speed3);
		// now add each button to the frame's content pane
		this.getContentPane().add(speed1);
		this.getContentPane().add(speed2);   
		this.getContentPane().add(speed3);
		this.getContentPane().add(panel);

		//start button listener
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hrunner != null)
				{  
					stopflag=true;
				}
				hrunner = new Thread(new Runnable() {
					public void run()
					{
						resetList();  
						stopflag=false;
					} // end of run
				}); // end of creating a new Thread hrunner
				hrunner.start(); // add the Thread to the process queue
			}});

		//stop listener
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopflag = true; 
			}});

		//reset listener
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopflag=true;
				resetList();
			}});
		progspeed = 250;  // default speed  
	}
	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
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
		SortFrame frame = new SortFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}

	/** main method, really just creates the gui frame (window) and
	 *  waits (listens) for user actions (inputs).
	 * @param args - command line arguments - none expected
	 */ 
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	/** used to reset the panel and frame when user clicks
	 * the reset button, so the towers are reset to the
	 * original number of rings as shown in the ringText
	 *
	 */  

	public void resetList()
	{
		Random ran=new Random();

		for(int i=0; i<list.length;i++)
		{
			list[i]=ran.nextInt(600)+1;
		}

		repaint();      // this should paint the panel by looking at the towers to 
		// determine where to draw a ring and on which tower
	}
	
	public int[] populateList(int list[])
	{
		Random ran=new Random();

		for(int i=0; i<list.length; i++)
		{
			list[i]=ran.nextInt(601);
		}
		return list;
	}

	/** the method which controls the "moving of the rings on the 3 towers."
	 * 
	 * @param n - number of rings
	 * @param src - name of the current source tower
	 * @param st  - tower which contains the source
	 * @param mid - name of the middle tower
	 * @param mt - tower which contains the middle 
	 * @param dst - name of the destination tower
	 * @param dt - tower that contains the destination
	 */  
	/*public void merge(int list[], int low, int high)
	{ 
		if(stopflag == false) // in case the user pressed the stop button, if not keep in
		{
			if (n == 1)
				moveRing(n,src,st,dst,dt);  // base case? 1 ring to move from src to destination tower
			else
			{
				hanoi(n-1,src,st,dst,dt,mid,mt); // have hanoi move n-1 rings from src to middle
				moveRing(n,src,st,dst,dt);       // move the nth ring to dest.
				hanoi(n-1,mid,mt,src,st,dst,dt); // have hanoi move n-1 rings from middle to destination
			}
		}
	}
	 */
	/** physically moves rings from src to destination tower
	 *   (these are implemented as StackVs, so it works well. 
	 * @param n - number of ring to move	
	 * @param src - name of tower that the nth ring is on
	 * @param st  - the tower (StackV) containing the ring being moved
	 * @param dst - name of the tower to move the nth ring to
	 * @param dt - the StackV (tower) to place ring n on
	 */

	/*public void mergeSort(int [] list, int low1, int high1, int low2, int high2)
	{
		if(stopflag==false) // don't move anything if user pressed stop.
		{
			int st1 = ((Integer)st.pop()).intValue();
			System.out.println("Move ring " + st1 + " from " + src + " to " + dst);
			dt.push(new Integer(st1)); // move ring n from top of source to top of dest.
			repaint();
			// now check speed selected again and reset 
			if(speed1.isSelected())
				progspeed=750;
			else if(speed2.isSelected())
				progspeed=500;
			else
				progspeed = 250;

			try{ 
				Thread.sleep(progspeed);  // make current thread running sleep so we can listen to
				// other buttons and see the towers after a paint
			} catch(InterruptedException e) { System.out.println("Error in thread sleep " + e);
			}
		}// end if stopflag is false if its true, fall out and do nothing 
	}
	 */
	/** this class is used to draw the towers in a panel
	 *  (in java swing, JPanels are like canvases that you can draw things on.)
	 * @author LJB
	 *
	 * 
	 */
	class MyPanel extends JPanel
	{
		public static final int MYWIDTH=700;
		public static final int MYHEIGHT=600;
		private int myList[];
		private boolean stopflag;

		MyPanel(int list[])
		{
			this.myList=list;
			this.setPreferredSize(new Dimension(MYWIDTH,MYHEIGHT));

		}


		/**this is the method that actually draws on the panel,
		 *  its inherited from JPanel
		 *  @parm g - the object to use to draw/paint with
		 */
		public void paintComponent(Graphics g)
		{ 
			super.paintComponent(g); // always paint the parent!
			g.setColor(Color.yellow);// change to yellow
			for(int i=0; i<myList.length; i++)
			{
				g.drawLine(i, MYWIDTH, i, MYHEIGHT-(myList[i]));
			}
		}

		/**
		 * draws (paints) the rings on the "towers"
		 * @param g - object from paintComponent to paint with on this panel
		 */
		/*public void drawLines(Graphics g) {
		}*/

		/*public void drawTower(Graphics g, int loc, StackV<Integer>t){
			int len = t.size();
			// copy the tower before we pop it
			StackV<Integer> copyTower = new StackV<Integer>();
			t.copy(copyTower); // make a copy of the tower we are drawing
			int xloc = loc * 150 - 50;
			int yloc = 485 - len * 48;
			int yincrement = 48;
			while (!copyTower.isEmpty()){ 
				// draw each ring from top of tower to bottow (pop each)
				int ring = ((Integer)copyTower.pop()).intValue();
				g.fillOval(xloc-(ring*7)/2, yloc, ring*14, ring*6);
				yloc = yloc + yincrement;
			}// end while
		}// end of drawTower*/
	}// end MyPanel
} // HanoiTest


package lab7;
/**
 * @author Laura Baker
 * @version 1.1
 * program to demonstrate use of GUI 
 *  create a simple demo of a few stack operations
 * 
 * 
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class StackFrame extends JFrame 
{
	/** these are all of the widgets (parts) that go on the Frame
	 *  Buttons for execution control, TextFields for input and output
	 */
	public static final int FRAMEHEIGHT=500;
	public static final int FRAMEWIDTH=700;
	JButton stackButton;
	JButton pushButton;
	JButton showButton;
	JButton clearButton;

	JTextArea area;
	JPanel buttonPanel ;
	JTextField field;
	StackList <String> stackA;
	StackList<String> stackL;
	boolean isStackA;  // flag to tell us which stack we are using

	/* Default Frame constructor, initializes the frame's components */
	public StackFrame()
	{
		// first create the buttons and widgets to put on the frame

		pushButton = new JButton("Push Item");
		showButton = new JButton("Show Stack");
		stackButton = new JButton("Switch Stacks");
		clearButton = new JButton("Clear Stack");
		field = new JTextField(18);
		area = new JTextArea(10,50);
		field.setText("Now using stackA");
		stackA = new StackAImpl<String>();
		stackL = new StackLImpl<String>();
		isStackA=true;

		buttonPanel = new JPanel();  // used to keep the buttons together
		// 
		this.setTitle("Stack Testing");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(buttonPanel);
		this.getContentPane().add(field);
		this.getContentPane().add(area);
		buttonPanel.add(pushButton);
		buttonPanel.add(showButton);
		buttonPanel.add(stackButton);
		buttonPanel.add(clearButton);

		area.setEditable(false); // its now UNchangeable
		pushButton.addActionListener( new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				doPush();
			}});


		stackButton.addActionListener( new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				isStackA = !isStackA;
				if(isStackA)
				{
					field.setText("Now using stackA");
					area.setText("\n\nContents of stackA:\n"+stackA);
				}
				else
				{
					field.setText("Now using stackL");
					area.setText("\n\nContents of stackL:\n"+stackL);
				}

			}});



		showButton.addActionListener( new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(isStackA)
					area.setText("Contents of stackA:\n"+stackA.toString());
				else
					area.setText("Contents of stackL:\n"+stackL.toString());
			}});

		clearButton.addActionListener( new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(isStackA)
				{
					stackA.clear();
					area.setText("Just cleared stackA\nContents of stackA:\n"+stackA.toString());
				}
				else
				{
					stackL.clear();
					area.setText("Just cleared stackL\nContents of stackL:\n"+stackL.toString());
				}
			}});


	}// end of constructor

	// method to manage push onto a stack
	// pre: none
	// post: if not full, the currently used stack has a new value pushed onto it
	public void doPush()
	{
		String item = JOptionPane.showInputDialog(this, "Enter value to push", "");
		if(isStackA)
		{
			if(!stackA.isFull())
			{
				stackA.push(item);
				area.setText("Just pushed " + item + " onto stackA\n\nContents of stackA:\n"+stackA);
			}
			else
			{
				area.setText("Cannot push onto stackA, its currently full at : "+stackA.size()+
						" items\n\nContents of stackA is: \n"+stackA);
			}
		}
		else
		{   if(!stackL.isFull())
		{
			stackL.push(item);
			area.setText("Just pushed " + item + " onto stackL\n\nContents of stackL:\n"+stackL);
		}
		else
		{
			area.setText("Cannot push onto stackL, its currently full at : "+stackL.size()+
					" items\n\nContents of stackL is: \n"+stackL);
		}
		}
	}



	/** main method, really just creates the frame (window) and
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
	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Make sure we have nice window decorations so use default for system
		JFrame.setDefaultLookAndFeelDecorated(true);    

		//Create and set up the window.
		StackFrame frame = new StackFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(StackFrame.FRAMEWIDTH, StackFrame.FRAMEHEIGHT);
		//Display the window.
		frame.setVisible(true);

	} // end createAndShowGui

}// end StackFrameExample class

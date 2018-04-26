package lab10;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;


public class QueueFrame<T> extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int FRAMEWIDTH=700;
	public static final int FRAMEHEIGHT=500;
	JButton add; 
	JButton remove;
	JButton clear;
	JButton change;
	JButton full;
	JButton empty;
	JButton first;
	JButton last;
	JButton show;
	JButton size;
	JButton maxSize;

	QueueList <String> queue;

	JTextArea area;
	JTextField field;
	JPanel buttonPanel;
	JPanel buttonPanel2;

	//pre: n/a
	//post: frame constructor
	public QueueFrame()
	{
		add = new JButton("Add");
		remove = new JButton("Remove");
		clear = new JButton ("Clear");
		change = new JButton ("Change Size");
		full = new JButton("Full?");
		empty = new JButton("Empty?");
		first = new JButton("First?");
		last = new JButton("Last?");
		show = new JButton("Show Queue");
		size = new JButton("Size");
		maxSize= new JButton("Max Size");
		queue= new QueueListImpl<String>();

		field = new JTextField(18);
		area = new JTextArea(10,50);


		buttonPanel = new JPanel();
		buttonPanel2=new JPanel();
		// used to keep the buttons together
		// button Panel 2 used as a seperate row
		this.setTitle("Queue Testing");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(buttonPanel);
		this.getContentPane().add(buttonPanel2);
		this.getContentPane().add(area);
		buttonPanel.add(add);
		buttonPanel.add(remove);
		buttonPanel.add(clear);
		buttonPanel.add(size);
		buttonPanel.add(maxSize);
		buttonPanel.add(change);
		buttonPanel2.add(full);
		buttonPanel2.add(empty);
		buttonPanel2.add(show);
		buttonPanel2.add(first);
		buttonPanel2.add(last);

		area.setEditable(false);

		//listeners below
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdd();
			}});

		maxSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText("The max elements you can add to the current queue is " + queue.getMaxSize());
			}});


		size.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSize();
			}});
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText(queue.toString());
			}});

		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doChange();
			}});


		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!queue.isEmpty())
				{
					String item=queue.remove();
					area.setText("Just removed " + item + " from the queue.");
				}
				else
				{
					area.setText("Could not remove item from the queue...");
				}
			}});

		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(queue.isEmpty())
				{
					area.setText("Could not get the front item...");
				}
				else
				{
					area.setText("The first item in the queue is " + queue.front());
				}
			}});

		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(queue.isEmpty())
				{
					area.setText("Could not get the last item...");
				}
				else
				{
					area.setText("The last item in the queue is " + queue.last());
				}
			}});

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queue.clear();
				area.setText("Queue cleared.");
			}});

		empty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(queue.isEmpty())
				{
					area.setText("Queue is empty");
				}
				else
				{
					area.setText("Queue has some items in it...");
				}
			}});

		full.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(queue.isFull())
				{
					area.setText("Queue is full");
				}
				else
				{
					area.setText("Queue has some room in it...");
				}
			}});

	}

	//do methods below
	public void doAdd()
	{
		String item = JOptionPane.showInputDialog(this, "Enter value to push", "");
		if(!queue.isFull())
		{
			queue.add(item);
			area.setText("Just added " + item + " into the queue\n");
		}
		else
		{
			area.setText("Cannot add into queue, its currently full at : "+queue.size()+
					" items\n\nContents of queue is: \n"+queue);
		}
	}

	public void doSize()
	{
		int currentSize=queue.size();
		area.setText("The current size of the queue is: "+ currentSize);
	}
	public void doChange()
	{
		String item = JOptionPane.showInputDialog(this, "Enter value: ", "");
		int userInput=Integer.parseInt(item);

		queue.setMaxSize(userInput);
		area.setText("Changed number of elements");
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	private static void createAndShowGUI() {
		//Make sure we have nice window decorations so use default for system
		JFrame.setDefaultLookAndFeelDecorated(true);    

		//Create and set up the window.
		QueueFrame<String> frame = new QueueFrame<String>();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(QueueFrame.FRAMEWIDTH, QueueFrame.FRAMEHEIGHT);
		//Display the window.
		frame.setVisible(true);

	}
}
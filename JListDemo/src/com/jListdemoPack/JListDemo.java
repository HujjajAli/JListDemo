package com.jListdemoPack;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import com.beanClasses.Student;


public class JListDemo
{
	//l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Default Multiple Selection With this Single Selection
	
	JFrame f = new JFrame();
	JList<Student> names = new JList<Student>();
	Vector<Student> list = new Vector<Student>();
	//ArrayList<String> list = new ArrayList<String>();
	
	//String a[] = {"Hujaj Ali","Sajjad Ali"};
	JLabel l = new JLabel("Hujaj");
	public JListDemo() 
	{
		display();
	}
	
	public void display()
	{
		f.setSize(500,500);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list.add(new Student("Hujaj Ali","2k15-ITC-63"));
		
		f.add(names);
		
		names.setBounds(30, 50, 200, 400);
		names.setListData(list);
	}
	
	public static void main(String[] args)
	{
		new JListDemo();
	}
	

}

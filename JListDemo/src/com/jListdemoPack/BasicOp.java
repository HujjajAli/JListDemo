package com.jListdemoPack;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.beanClasses.Student;



public class BasicOp implements ActionListener,ListSelectionListener
{
	JFrame j = new JFrame("Student Record");
	DefaultListModel<Student> model = new DefaultListModel<Student>();
	JList<Student> record = new JList<Student>(model);
	
	
	JScrollPane scrollPane = new JScrollPane(record);
	
	JLabel lblName = new JLabel("Enter Name:");
	JLabel lblRoll = new JLabel("Enter Roll No:");
	JLabel lblTitleName = new JLabel("Student Name");
	JLabel lblTitleRoll = new JLabel("Student Roll_No");
	
	JTextField nameField = new JTextField();
	JTextField rollField = new JTextField();
	
	JButton insert = new JButton("INSERT");
	JButton update = new JButton("UPDATE");
	JButton delete = new JButton("DELETE");
	
	String sName = "null";
	String sRoll = "null";
	
	
	
	public BasicOp()
	{	
		j.setBounds(300, 40, 400, 500);
		j.setVisible(true);
		j.setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		j.add(record);
		j.add(insert);
		j.add(update);
		j.add(delete);
		j.add(nameField);
		j.add(rollField);
		j.add(lblName);
		j.add(lblRoll);
		j.add(lblTitleName);
		j.add(lblTitleRoll);
		//record.add(scrollPane);
		j.add(scrollPane,BorderLayout.NORTH);
		
		record.setBounds(10, 70, 200, 500);
	//	scrollPane.setBounds(190, 210, 20, record.getHeight());
		
		lblTitleName.setBounds(10, 50, 100, 20);
		lblTitleRoll.setBounds(115, 50,100, 20);
		lblName.setBounds(220, 65, 100, 20);
		lblRoll.setBounds(220, 120, 100, 20);
		
		nameField.setBounds(220, 85, 100, 20);
		rollField.setBounds(220, 140, 100, 20);
		
		insert.setBounds(220, 200, 100, 40);
		update.setBounds(220, 250, 100, 40);
		delete.setBounds(220, 300, 100, 40);
		
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		
		record.addListSelectionListener(this);
		
	}
	
	public void addData(String name,String roll)
	{
		model.addElement(new Student(name,roll));
	}
	
	public void deleteData(int index)
	{
		model.removeElementAt(index);
		
	}
	
	public void updateData(Student s,int index)
	{
		model.setElementAt(s,index);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if(e.getSource()==insert)
		{
			sName  = nameField.getText();
			sRoll  = rollField.getText();
			addData(sName,sRoll);
			
		}
	    else if(e.getSource() == delete)
		{
	    	int index =this.record.getSelectedIndex();
			
			if(index>=0)
			{
				deleteData(index);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please Select any Record to Delete");
			}
		}
	    else if(e.getSource() == update)
	    {
	        int index =this.record.getSelectedIndex();
				
			if(index>=0)
			{
				
				this.updateData(new Student(nameField.getText(),rollField.getText()), index);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please Select any Record to Delete");
			}
		    	
	    }
	}

	public static void main(String[] args)
	{
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            	System.out.println(info.getClassName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BasicOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BasicOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BasicOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BasicOp.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		BasicOp o = new BasicOp();
		
        
		
		//o.deleteData();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
	
	}



	

}

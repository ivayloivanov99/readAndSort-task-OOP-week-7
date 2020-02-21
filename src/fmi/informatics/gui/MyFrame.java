package fmi.informatics.gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import fmi.informatics.extending.Person;
import fmi.informatics.util.FileReader;


public class MyFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	Person[] people = FileReader.readPeople();
	ArrayList<Person> peopleList = new ArrayList<Person>();	
	public MyFrame() {
		this.setSize(600, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,1));
		
		for (Person person : people) {
			peopleList.add(person);	
		}	

		JPanel buttonPanel = new JPanel();
		JPanel tablePanel = new JPanel();
		
		JButton sortLastASCButton = new JButton("Sort Last Name (ASC)");
		JButton sortLastDSCButton = new JButton("Sort Last Name (DSC)");
		JButton sortFirstASCButton = new JButton("Sort First Name (ASC)");
		JButton sortFirstDSCButton = new JButton("Sort First Name (DSC)");
		JButton searchFamilyButton = new JButton("Search Family Name");
		JButton firstNameCountButton = new JButton("Filter First Name");
		
		PersonDataModel personDataModel = new PersonDataModel(peopleList);

		JTable table = new JTable(personDataModel);		
		JScrollPane scroller = new JScrollPane(table);		
		this.add(tablePanel);
		this.add(buttonPanel);
		
		buttonPanel.setLayout(new GridLayout(3,1));
		buttonPanel.add(sortLastASCButton);
		buttonPanel.add(sortLastDSCButton);
		buttonPanel.add(sortFirstASCButton);
		buttonPanel.add(sortFirstDSCButton);
		buttonPanel.add(searchFamilyButton);
		buttonPanel.add(firstNameCountButton);

		scroller.setPreferredSize(new Dimension(550,200));
		tablePanel.add(scroller);
			
		firstNameCountButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				Person[] people = new Person[1];
				people[0] = new Person();
				String input = JOptionPane.showInputDialog("Enter name you wish to count:");
				 int counter = 0;
				 for(int i = 0;i<peopleList.size();i++) {
					 if(peopleList.get(i).getFirstName().toString().equals(input)) {
						counter++;					
					 }
				 }
				FilterDataModel filterDataModel = new FilterDataModel(people);

				 people[0].setFirstName(input);
				 people[0].setNameCounter(counter);

				table.setModel(filterDataModel);
				 table.repaint();			
			}
		});
		
		searchFamilyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				 String input = JOptionPane.showInputDialog("Enter last name you are looking for:");
				 for(int i = 0;i<peopleList.size();i++) {
					 if(!(peopleList.get(i).getLastName().toString().equals(input))) {
						peopleList.remove(i); 
					 }
				 }
				 table.repaint();			
			}
		});
		
		sortLastASCButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p1.getLastName().compareTo(p2.getLastName());
				    }				    				    
				});							
				table.repaint();
			}
		});
		
		sortLastDSCButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p2.getLastName().compareTo(p1.getLastName());
				    }				    				    
				});							
				table.repaint();
			}
		});
		
		sortFirstASCButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p1.getFirstName().compareTo(p2.getFirstName());
				    }				    				    
				});							
				table.repaint();
			}
		});
		
		sortFirstDSCButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p2.getFirstName().compareTo(p1.getFirstName());
				    }				    				    
				});							
				table.repaint();
			}
		});
		
		
		this.setVisible(true);
	}//end constructor
		
	
}//end class MyFrame

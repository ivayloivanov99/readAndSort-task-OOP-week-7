package fmi.informatics.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fmi.informatics.extending.Person;

//Създаваме клас PersonDataModel
public class PersonDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Person> peopleList = new ArrayList<Person>();	

	// constructor
	public PersonDataModel(ArrayList<Person> peopleList) {
		this.peopleList = peopleList;
	}

	@Override
	public int getColumnCount() {
		return 3; // брой колони в таблицата
	}

	@Override
	public int getRowCount() {
		return peopleList.size(); // брой редове в таблицата
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return peopleList.get(rowIndex).getFirstName();
			case 1:
				return peopleList.get(rowIndex).getMiddleName();
			case 2:
				return peopleList.get(rowIndex).getLastName();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "First name";
			case 1:
				return "Middle name";
			case 2:
				return "Last name";	
			default:
				return super.getColumnName(column);
		}
	}
}

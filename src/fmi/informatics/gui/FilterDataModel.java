package fmi.informatics.gui;

import javax.swing.table.AbstractTableModel;

import fmi.informatics.extending.Person;

//Създаваме клас PersonDataModel
public class FilterDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	Person[] people;

	// constructor
	public FilterDataModel(Person[] people) {
		this.people = people;
	}

	@Override
	public int getColumnCount() {
		return 2; // брой колони в таблицата
	}

	@Override
	public int getRowCount() {
		return people.length; // брой редове в таблицата
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return people[rowIndex].getFirstName();
			case 1:
				return people[rowIndex].getNameCounter();

		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "First name";
			case 1:
				return "Name Count";
			default:
				return super.getColumnName(column);
		}
	}
}

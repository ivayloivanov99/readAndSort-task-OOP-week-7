package fmi.informatics.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import fmi.informatics.extending.Person;


public class FileReader {

	private static final String PERSON_FILE_EXTENSION = ".file";
	private static final String PERSON_FILE_NAME = "people";
	private static final String FILE_PATH = "src/fmi/informatics/files/";
	private static final String FULL_PATH = FILE_PATH + PERSON_FILE_NAME + PERSON_FILE_EXTENSION;
	
	private static ArrayList<Person> peopleList = new ArrayList<>();
	
	public static void createPersonFile() {
		File file = new File(FULL_PATH);
		file.getParentFile().mkdirs();
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Файлът не може да бъде създаден!");
			e.printStackTrace();
		}
	}
	
	public static boolean isFileExists() {
		File file = new File(FULL_PATH);
		return file.exists();
	}
	
	@SuppressWarnings("resource")
	public static Person[] readPeople() {
		try {
			FileInputStream fileStream = new FileInputStream(FULL_PATH);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream));
			String stringLine;
			
			while((stringLine = bufferedReader.readLine()) != null) {
				String[] data = stringLine.split("\t");
				addPerson(data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Person[] people = new Person[peopleList.size()];
		return peopleList.toArray(people);
	}
	
	
	private static void addPerson(String[] data) {

			Person person = new Person(
					data[0], data[1], data[2]);
			
			peopleList.add(person);
		
		
	}

	
}

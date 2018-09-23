package Mylittlediary.diary;
	

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Diary {

	public ArrayList<Notes> notes;
	
	
	public Diary(){
		notes = new ArrayList<>();
	}
	
	public ArrayList<Notes> getNotes(){
		return notes;
	}
	
	public void addNote(Notes note){
		notes.add(note);
	}
	
	
	
	
	
	public void readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		notes = (ArrayList<Notes>) objectInputStream.readObject();
		fileInputStream.close();
	}
	
	public void saveToFile(String fileName) throws FileNotFoundException, IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(notes);
		fileOutputStream.close();
		
	}
	
	
	public void remove(String toRemove){
		for(int i = 0; i<notes.size(); i++){
			if(toRemove.equals(notes.get(i).getDate())){
				notes.remove(i);
			}
		}
	}
	
	
	
	
	
	
	
	
	
}

package Mylittlediary.diary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class savetest {

	@Test
	public void test() {
		Diary dv = new Diary();
		Notes n = new Notes("utolso", "2012.12.05");
		 dv.addNote(n);
		 
		 try {
			dv.saveToFile("test.txt");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		 
		 Diary uj = new Diary();
		 
		 try {
			uj.readFromFile("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 assertEquals("utolso", uj.notes.get(0).getEventName());
		 
		 
		 
	}

}

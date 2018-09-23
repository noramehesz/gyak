package Mylittlediary.diary;

import static org.junit.Assert.*;

import org.junit.Test;

public class addtest2 {

	@Test
	public void test() {
		Diary d = new Diary();
		Notes n = new Notes("lol", "2012.01.01.");
		
		d.addNote(n);
		
		assertEquals("lol", n.getEventName());
	}

}

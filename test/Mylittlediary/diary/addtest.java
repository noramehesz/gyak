package Mylittlediary.diary;

import static org.junit.Assert.*;

import org.junit.Test;

public class addtest {

	@Test
	public void test() {
		Diary test = new Diary();
		Notes egy = new Notes();
		test.addNote(egy);

		assertNotNull(test);
	}

}

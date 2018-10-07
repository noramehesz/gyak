package Mylittlediary.view;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SearchNoteTest {

	@Test
	public void test() {
		DiaryView  dv = new DiaryView();
		dv.setVisible(true);
		dv.setBounds(100, 100, 500, 500);
		
		Assert.assertEquals("jegyzet" , dv.getTxtrJegyzet().getText());
	}

}

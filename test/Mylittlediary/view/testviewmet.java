package Mylittlediary.view;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class testviewmet {

	@Test
	public void test() {
		DiaryView  dv = new DiaryView();
		dv.setVisible(true);
		dv.setBounds(100, 100, 500, 500);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(true , dv.varninglbl.getText().equals("")); // ha nem nyomok meg semmilyen gombot, a hozzáad panelen nem jelenik meg semmi
		
	}
	

	

}

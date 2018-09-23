package Mylittlediary.view;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testvw {

	@Test
	public void test() {
		DiaryView  dv = new DiaryView();
		dv.setVisible(true);
		dv.setBounds(100, 100, 500, 500);
		
		
		//txtDatum
		Assert.assertEquals("éééé.hh.nn." , dv.txtDatum.getText());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("" , dv.txtDatum.getText());   //hozzáadáskot a dátum mezõn kattintva eltûnik az "éééé.hh.nn."
	}

}

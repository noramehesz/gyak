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
		Assert.assertEquals("����.hh.nn." , dv.txtDatum.getText());  
		 
		//try {
			Thread.sleep(5000);   //5 mp van belekattintani a txtDatum mezobe, hogy ellenorizzuk h eltunik e mintas belole
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		Assert.assertEquals("" , dv.txtDatum.getText());   //hozzáadáskot a dátum mezőn kattintva eltűnik az "éééé.hh.nn."
	}

}

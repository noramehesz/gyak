package Mylittlediary.view;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class test3 {

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

		Assert.assertEquals("Ilyened már van, csak módosítani lehet" , dv.varninglbl.getText()); //figyelmeztet ha már an ehhez a naphoz adott bejegyzés
	}                                                                                            //2x a hozzáad gombra

}

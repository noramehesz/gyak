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
		
		//try {
			Thread.sleep(5000);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}

		Assert.assertEquals("Ilyened m�r van, csak m�dos�tani lehet" , dv.varninglbl.getText()); //figyelmeztet ha m�r an ehhez a naphoz adott bejegyz�s
	}                                                                                            //2x a hozz�ad gombra

}

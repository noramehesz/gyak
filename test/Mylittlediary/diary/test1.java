package Mylittlediary.diary;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class test1 {

	@Test
	public void test() {
     Notes a = new Notes();
	a.setEventName("haha");
	
	assertEquals("haha", a.getEventName());
	}

	
	
	@Test
	public void test2() {
	 Notes e = new Notes();
	 e.setDate("2012.02.02.");
		
	 assertEquals("2012.02.02.", e.getDate());
	}
	
	
	
	@Test
	public void test3() {
		Notes f = new Notes("hihi", "2012.10.01.");
		String k = f.getEventName();
		
		assertEquals("hihi", k);
		
	}
	
	
	
	
	@Test
	public void test4(){
		Notes h = new Notes("hihe", "2012.03.03.");
		String c  = h.getDate();
		
		assertEquals("2012.03.03.", c);
		
		
		
		
	}
	

}

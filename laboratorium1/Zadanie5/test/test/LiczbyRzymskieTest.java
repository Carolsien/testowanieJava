package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LiczbyRzymskieTest {

	private LiczbyRzymskie liczby;
	
	@Test
	public void checkLiczba(){
		liczby = new LiczbyRzymskie(10);
		assertEquals("X", liczby.toString());
	}
	
	@Test
	public void checkLiczbaZlozona(){
		liczby = new LiczbyRzymskie(53);
		assertEquals("LIII",liczby.toString());
	}
	
	@Test
	public void liczbaNotNull() {
		liczby = new LiczbyRzymskie(25);
		assertNotNull(liczby.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void liczbaIsNegativeNumber() {
		liczby = new LiczbyRzymskie(-1);
		liczby.toString();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void liczbaIsZero(){
		liczby = new LiczbyRzymskie(0);
		liczby.toString();
	}
	
	@After
	public void teardown(){
		liczby = null;
	}

}

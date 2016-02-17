package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NwdTest {
	
	private Nwd test;
	
	@Before
	public void setup(){
		test = new Nwd();
	}
	
	@Test
	public void CheckFirstZero(){
		assertEquals(9, test.nwd(0, 9));
	}
	
	@Test
	public void CheckSecondZero(){
		assertEquals(9, test.nwd(9, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckBothZero(){
		test.nwd(0, 0);
	}
	
	@Test 
	public void NwdCheck(){
		assertEquals(6, test.nwd(174, 18));		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NwdShouldThrowAnException_FirstNegative(){
		test.nwd(-3, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NwdShouldThrowAnException_SecondNegative(){
		test.nwd(3, -2);
	}

	@After
	public void teardown(){
		test = null;
	}
}

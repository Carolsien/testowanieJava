package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class CalculatorDoubleTest {

	private CalculatorDouble calc = new CalculatorDouble();
	private static double przyblizenie = 1E-10;
	
	@Test
	public void addCheck(){
		assertEquals(5.5, calc.add(3.5, 2.0), przyblizenie);		
	}
	
	@Test
	public void subCheck(){
		assertEquals(1.25, calc.sub(3.75, 2.5), przyblizenie);	
	}
	
	@Test
	public void multiCheck(){
		assertEquals(8.75, calc.multi(3.5, 2.5), przyblizenie);	
	}
	
	@Test
	public void divCheck(){
		assertEquals(3.125, calc.div(6.25, 2), przyblizenie);
		assertEquals(0.5, calc.div(2.0, 4.0), przyblizenie);
	}
	
	@Test
	public void greaterCheck(){
		assertEquals(true, calc.greater(6.25, 2.0));	
		assertEquals(false, calc.greater(1.36, 2));	
		assertEquals(false, calc.greater(1.45, 1.45));
	}
	
	@After
	public void teardown(){
		calc = null;
	}
}

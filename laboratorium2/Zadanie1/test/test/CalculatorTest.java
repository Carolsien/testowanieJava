/*
 Do kalkulatora z zadania 2 (Labolatorium 1) powtórzyć testy jednostkowe, używając
biblioteki
Hamcrest
 */

package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.Calculator;
import static org.hamcrest.Matchers.*;


public class CalculatorTest {
	
	private Calculator calc;
	
	@Before
	public void setup(){
		calc = new Calculator();
	}

	@Test
	public void addCheck(){	
		int add1 = calc.add(3,2);		
		assertThat(5, equalTo(add1));		
	}
	
	@Test
	public void subCheck(){
		int sub1 = calc.sub(3, 2);
		assertThat(1, equalTo(sub1));	
	}
	
	@Test
	public void multiCheck(){
		int multi1 = calc.multi(3, 2) ;
		assertThat(multi1, is(6));	
	}
	
	@Test
	public void divCheck(){
		int div1 = calc.div(6, 2);
		int div2 = calc.div(2, 6);
		assertThat(3, equalTo(div1));
		assertThat(div2, is(0));
	}
	
	@Test
	public void greaterCheck(){
		boolean greater1 = calc.greater(6, 2);
		boolean greater2 = calc.greater(1, 2);
		boolean greater3 = calc.greater(1, 1);
		
		assertTrue(greater1);	
		assertFalse(greater2);	
		assertFalse(greater3);
	}

	@After
	public void teardown(){
		calc = null;
	}
}

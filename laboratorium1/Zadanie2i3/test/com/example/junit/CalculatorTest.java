/*
Napisz klasę CalculatorTest, która będzie klasą testującą dla klasy Calculator.
Zaplanuj i zaimplementuj odpowiednie przypadki testowe (sprawdzające poprawność
wykonywanych operacji). Skorzystaj z różnych asercji.

Rozszerz klasę CalculatorTest o przypadek testowy, który zakończy się
błędem, gdy przy próbie dzielenia przez 0 nie wystąpi wyjątek typu ArithmeticException.
 */

package com.example.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	private Calculator calc = new Calculator();
	
	@Test
	public void addCheck(){
		assertEquals(5, calc.add(3, 2));		
	}
	
	@Test
	public void subCheck(){
		assertEquals(1, calc.sub(3, 2));	
	}
	
	@Test
	public void multiCheck(){
		assertEquals(6, calc.multi(3, 2));	
	}
	
	@Test(expected = ArithmeticException.class)
	public void divby0Check(){
		calc.div(3, 0);
	}
	
	@Test
	public void divCheck(){
		assertEquals(3, calc.div(6, 2));
		assertEquals(0, calc.div(2, 6));
	}
	
	@Test
	public void greaterCheck(){
		assertEquals(true, calc.greater(6, 2));	
		assertEquals(false, calc.greater(1, 2));	
		assertEquals(false, calc.greater(1, 1));
	}
}

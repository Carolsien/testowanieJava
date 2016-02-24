package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class SortingTest {
	private Sorting test;

	@Test
	public void bubbleSortShouldWork() {
		Integer[] temp = { 8, 1, 11, -5 };
		test = new Sorting(temp);
		test.bubbleSort();
		assertThat(Arrays.asList(test.table), contains(-5, 1, 8, 11));
	}
	
	@Test
	public void tableLengthisZero(){
		Integer[] tmp = {};
		test = new Sorting(tmp);
		try{
			test.bubbleSort();
		}catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void tableIsNull(){
		test = new Sorting(null);
		try{
			test.bubbleSort();
		}catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@After
	public void tearDown() {
		test = null;
	}

}

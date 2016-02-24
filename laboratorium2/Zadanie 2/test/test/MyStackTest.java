package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class MyStackTest {
	private MyStack test;
	
	@Before
	public void setup(){
		test = new MyStack();
	}

	@Test
	public void myPushShoulWork() {
		test.myPush(1);
		assertThat(test.isNull(), is(false));
	}
	
	@Test
	public void myPopShoulWork() {
		test.myPush(2);
		test.myPop();
		assertThat(test.isNull(), is(true));
	}
	
	@Test
	public void myPopShoulWorkNull() {
		try{
			test.myPop();
			} catch (IllegalArgumentException e) {
				assertThat(test.isNull(), is(false));
			}
		}
	
	@Test
	public void myTopShoulWork() {
		test.myPush(4);
		test.myTop();
		assertThat(test.myTop().getWartosc(), is(4));
	}
	
	@Test
	public void isNullShouldWork(){
		test.myPush(4);
		test.myPop();
		assertThat(test.isNull(), is(true));
	}

	@After
	public void teardown(){
		test = null;
	}
}

package mavenTest.Stack;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	private MyStack stack;

	@Before
	public void setUp() throws Exception {
		stack = new MyStack();
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}

	@Test
	public void PopTest() {
			stack.MyPush(2);
			stack.MyPop();
			assertTrue(stack.IsEmpty());
	}
	
	@Test
	public void PopWhenStackIsEmpty(){
		try{
			stack.MyPop();
		}catch (NullPointerException e){
			assertTrue(stack.IsEmpty());
		}
	}
	
	@Test
	public void PushTest(){
		stack.MyPush(1);	
		assertFalse(stack.IsEmpty());
	}
	
	@Test
	public void MyTopIsEmptyTest(){
		try{
			stack.MyTop();
		}catch (NullPointerException e){
			assertTrue(stack.IsEmpty());
		}
	}
	
	@Test
	public void MyTopTest(){
		int a = 8;
		int b = 2;
		stack.MyPush(a);
		assertEquals(a, stack.MyTop());
		stack.MyPush(b);
		assertEquals(b, stack.MyTop());
		}

	@Test
	public void PushMaxIntegerTest(){
		stack.MyPush(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, stack.MyTop());
	}
	
	@Test
	public void PushMinIntegerTest(){
		stack.MyPush(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, stack.MyTop());
	}
}

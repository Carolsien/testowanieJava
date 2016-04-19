package maven.Stack;
import java.util.List;

import maven.Stack.MyStack;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
public class MySteps extends Steps{
	MyStack myStack = new MyStack();
	int element;
	

	@Given("the empty stack")
	public void givenTheEmptyStack(){
		myStack = new MyStack();
	}
	
	@Then("IsEmpty should be true")
	public void thenIsEmptyShouldBeTrue(){
		 if(myStack.IsEmpty() == true){
		 }
	}
	
}
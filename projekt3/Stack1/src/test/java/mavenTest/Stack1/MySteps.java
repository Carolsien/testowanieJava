package mavenTest.Stack1;
import java.util.List;

import mavenTest.Stack1.MyStack;

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
	

	@Given("the stack by $list0")
	public void givenTheStackBylist(@Named("list") List<Integer> list){
		 myStack = new MyStack(list);
	}
	
	@Then("IsEmpty should be false")
	public void thenIsEmptyShouldBeFalse(){
		 if(myStack.IsEmpty() != false){
			 throw new RuntimeException("Error");
		 }
	}
	
	@Given("the stack is empty")
	public void givenTheStackIsEmpty(){
		 myStack = new MyStack();
	}
	
	@Then("MyTop should throw an exception")
	public void thenMyTopShouldThrowAnException(){
		 try{
			 myStack.MyTop();
			 throw new RuntimeException("Error");
		 }catch(NullPointerException e){
			 
		 }
	}
	
	@Given("a  element by $element")
	public void givenAElementByelement(@Named("element") int element){
		element = element;
		myStack.MyPush(element);
		myStack.MyTop();
	}
	
	@When("I want to add element to the stack")
	public void whenIWantToAddElementToTheStack(){
		myStack.MyPush(element);
	}
	
	@Then("MyTop should be $element")
	public void thenMyTopShouldBeelement(@Named("element") int element){
		 if(myStack.MyTop() != element){
			 throw new RuntimeException("Error");
		 }	
	}
	
	@Given("the element by $element")
	public void givenTheElementByelement(@Named("element") int element){
		myStack.MyPush(element);
	}
	
	@Then("the stack should have $element")
	public void thenTheStackShouldHaveelement(){
		if(myStack.MyTop() != element){
			 throw new RuntimeException("Error");
		 }
	}
	

	
	@Given("I want to pop item")
	public void givenIWantToPopItem(){
		 try{
			 myStack.MyPop();
			 throw new RuntimeException("Error");
		 }catch (NullPointerException e){
			 
		 }
	}
	
	@Then("MyPop throws an exception")
	public void thenMyPopThrowsAnException(){
		try{
			 myStack.MyPop();
			 throw new RuntimeException("Error");
		 }catch(NullPointerException e){	 
		 }
	}


	@Then("the top of the stack should be $element")
	public void thenTheTopOfTheStackShouldBeelement(@Named("element") int element){
		element = element;
		if(myStack.MyTop() != element){
			 throw new RuntimeException("Error");
		 }
	}
}
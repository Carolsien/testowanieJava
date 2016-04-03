import java.util.List;

import mavenTest.Stack.MyStack;

import org.jbehave.core.annotations.*;
public class MySteps{
	
	MyStack myStack = new MyStack();
	int element;
	
	@Given("the stack by $list1")
	public void givenTheStackBylist1(@Named("list1") List<Integer> list1){
		 myStack = new MyStack(list1);
	}
	
	@Given("the stack is empty")
	public void givenTheStackIsEmpty(){
		 myStack = new MyStack();
	}
	
	@Then("MyPop throws an exception")
	public void thenMyPopThrowsAnException(){
		 try{
			 myStack.MyPop();
			 throw new RuntimeException("Error");
		 }catch(NullPointerException e){	 
		 }
	}
	
	@Then("MyTop should be $element3")
	public void thenMyTopShouldBeelement3(@Named("element3") int element3){
		 if(myStack.MyTop() != element3){
			 throw new RuntimeException("Error");
		 }	
	}
	
	@Then("the stack should have $element2")
	public void thenTheStackShouldHaveelement2(@Named("element2") int element2){
		if(myStack.MyTop() != element2){
			 throw new RuntimeException("Error");
		 }
	}
	
	@Given("a  element by $element3")
	public void givenAElementByelement3(@Named("element3") int element3){
		element = element3;
	}
	
	@Given("the element by $element2")
	public void givenTheElementByelement2(@Named("element2") int element2){
		element = element2;
	}
	
	@Given("the empty stack")
	public void givenTheEmptyStack(){
		myStack = new MyStack();
	}
	
	@Then("IsEmpty should be false")
	public void thenIsEmptyShouldBeFalse(){
		 if(myStack.IsEmpty() != false){
			 throw new RuntimeException("Error");
		 }
	}
	
	@When("I want to add element to the stack")
	public void whenIWantToAddElementToTheStack(){
		myStack.MyPush(element); 
	}
	@Then("MyTop should throw an exception")
	public void thenMyTopShouldThrowAnException(){
		 try{
			 myStack.MyTop();
			 throw new RuntimeException("Error");
		 }catch(NullPointerException e){
			 
		 }
	}
	
	@Then("IsEmpty should be true")
	public void thenIsEmptyShouldBeTrue(){
		 if(myStack.IsEmpty() == true){
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
	
	@Given("the stack by $list0")
	public void givenTheStackBylist0(@Named("list0") List<Integer> list0){
		 myStack = new MyStack(list0);
	}
	
	@Then("the top of the stack should be $element1")
	public void thenTheTopOfTheStackShouldBeelement1(@Named("element1") int element1){
		 if(myStack.MyTop() != element1){
			 throw new RuntimeException("Error");
		 }
	}
}
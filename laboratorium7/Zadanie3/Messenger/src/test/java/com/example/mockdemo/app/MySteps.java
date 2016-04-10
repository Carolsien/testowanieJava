package com.example.mockdemo.app;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import static org.junit.Assert.*;

public class MySteps extends Steps{
	
	MessageServiceMock ms;
	Messenger msn;
	String server;
	Integer result;
	String message;
	
	@BeforeStory
	public void setUp(){
		ms = new MessageServiceMock();
		msn = new Messenger(ms);
		result = null;
		server = null;
	}
	
	@Given("servers address by $server")
	public void givenServersAddressByserver(String server){
		 this.server = server;
	}
	
	@Given("bad connection")
	public void givenBadConnection(){
		 ms.setConnection(false);
	}
	
	@Given("good connection")
	public void givenGoodConnection(){
		 ms.setConnection(true); 
	}
	
	@When("connection is tested")
	public void whenConnectionIsTested(){
		result = msn.testConnection(server);
	}
	
	@Then("result should equal $result")
	public void thenResultShouldEqualresult(Integer result){
		 assertEquals(result, this.result);
	}
	
	@Given("message by $message")
	public void givenMessageBymessage(String message){
		 this.message = message;
	}
	
	@When("messager sends message")
	public void whenMessengerSendsMessage(){
		ms.setMessageSent(true);
	}
	
	@When("message can be send")
	public void whenMessageCanBeSend(){
		ms.setMessageSent(true);
	}


}
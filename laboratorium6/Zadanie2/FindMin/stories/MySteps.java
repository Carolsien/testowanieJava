import java.util.List;

import mavenTest.FindMin.App;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps{
	private List<Integer> list;
	App impl = new App();
	
	@Given("an array by $value")
	public void givenAnArrayByValue(@Named("value") List<Integer> value){
		list = value;
	}
	@Then("getMin should equal $value")
	@Pending
	public void thenGetMinShouldEqual(@Named("value") Integer value){
		 if(impl.getMin(list) != value){
			 throw new RuntimeException("Error in test");
		 }
	}
}
package mavenTest.Gra;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class HeheszkiSteps extends Steps{
	
	Kontrakt kontrakt = new Kontrakt();
	int liczba;
	Throwable thrown;

	@Given("liczba as $liczba1")
	public void givenLiczbaAsliczba(@Named("liczba1") int liczba1){
		 liczba = liczba1;
	}
	
	@When("liczba is smaller or equal zero")
	public void whenLiczbaIsSmallerOrEqualZero(){
		try{
			kontrakt.Heheszki(liczba);
		}catch (IllegalArgumentException e){
				
		}
	}
	
	@Then("Heheszki should throw an exception")
	public void thenHeheszkiShouldThrowAnException(){
		if(! thrown.getClass().getSimpleName().equals("NieudanyPsikusException")){
			throw new RuntimeException("Error");
		}
	}
	
	@Then("wynik as $wynik should be a random number smaller than liczba")
	public void thenWynikAswynikShouldBeARandomNumberSmallerThanLiczba(){
		kontrakt.Heheszki(liczba);
	}

}
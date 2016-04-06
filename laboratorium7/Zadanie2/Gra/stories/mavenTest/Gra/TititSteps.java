package mavenTest.Gra;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
public class TititSteps extends Steps{
	
	int liczba_dziel;
	Kontrakt kontrakt = new Kontrakt();
	Throwable thrown;
	
	@Given("an number as $liczba_dziel")
	public void givenAnNumberAsliczba_dziel(@Named("liczba_dziel1") int liczba_dziel1){
		liczba_dziel = liczba_dziel1;
	}
	
	@When("$liczba_dziel is zero")
	public void whenliczba_dzielIsZero(){
		try{
			kontrakt.Titit(0);
		}catch (IllegalArgumentException e){
			
		}
	}
	
	@Then("Titit should throw an exception")
	public void thenTititShouldThrowAnException(){
		if(! thrown.getClass().getSimpleName().equals("NieudanyPsikusException")){
			throw new RuntimeException("Error");
		}
	}
	
	@When("$liczba devided by $liczba_dziel is zero")
	public void whenliczbaDevidedByliczba_dzielIsZero(@Named("liczba1") int liczba1, @Named("liczba_dziel1") int liczba_dziel1){
		 kontrakt = new Kontrakt(liczba1);
		 liczba_dziel = liczba_dziel1;
	}
	
	@Then("Titit should return true")
	public void thenTititShouldReturnTrue(){
		if(kontrakt.Titit(liczba_dziel) != true){
			throw new RuntimeException("Error");
		}
	}

	@When("$liczba devided by liczba_dziel is not zero")
	public void whenliczbaDevidedByliczba_dzielIsNotZero(@Named("liczba2") int liczba2, @Named("liczba_dziel2") int liczba_dziel2){
		kontrakt = new Kontrakt(liczba2);
		 liczba_dziel = liczba_dziel2;
	}
	
	@Then("Titit should return false")
	public void thenTititShouldReturnFalse(){
		if(kontrakt.Titit(liczba_dziel) != false){
			throw new RuntimeException("Error");
		}
	}
}
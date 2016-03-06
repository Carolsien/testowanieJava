package mavenTest.Zadanie23;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class KontraktTest {
	private Kontrakt kontrakt;

	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
		kontrakt.liczba = 5;
	}

	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
	
	@Test
	public void HeheszkiRandomDzialaTest(){
		assertThat(kontrakt.Heheszki(5), greaterThanOrEqualTo(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void HeheszkiMniejszeNizZeroTest(){
		kontrakt.Heheszki(-3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void HeheszkiRowneZeroTest(){
		kontrakt.Heheszki(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TititLiczbaDzielJestZeremTest() {
		kontrakt.Titit(0);
	}
	
	@Test
	public void TititJestPodzielneTest(){
		assertTrue(kontrakt.Titit(5));	
	}
	
	@Test
	public void TititNieJestPodzielneTest(){
		assertFalse(kontrakt.Titit(10));
	}
}

package mavenTest.Zadanie23;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	@Test(expected = IllegalArgumentException.class)
	public void TititLiczbaDzielJestZeremTest() {
		kontrakt.Titit(0);
	}
	
	@Test
	public void TititJestPodzielne(){
		assertTrue(kontrakt.Titit(5));	
	}
	
	public void TititNieJestPodzielne(){
		assertFalse(kontrakt.Titit(10));
	}
	


}

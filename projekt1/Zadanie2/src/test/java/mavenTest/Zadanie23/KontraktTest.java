package mavenTest.Zadanie23;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

import static org.hamcrest.CoreMatchers.*;

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

	@Test
	public void czyZwrociArgumentTest() {
		int wartosc = kontrakt.Nieksztaltek(124);
		assertThat(wartosc, is(124));
	}

	@Test
	public void czyZamieniliczbe3Test() {
		int wartosc = kontrakt.Nieksztaltek(453);
		assertThat(wartosc, is(458));
	}

	@Test
	public void czyZamieniliczbe7Test() {
		int wartosc = kontrakt.Nieksztaltek(874);
		assertThat(wartosc, is(814));
	}

	@Test
	public void czyZamieniliczbe6Test() {
		int wartosc = kontrakt.Nieksztaltek(624);
		assertThat(wartosc, is(924));
	}

	@Test(expected = IllegalArgumentException.class)
	public void HeheszkiMniejszeNizZeroTest() {
		kontrakt.Heheszki(-3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void HeheszkiRowneZeroTest() {
		kontrakt.Heheszki(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TititLiczbaDzielJestZeremTest() {
		kontrakt.Titit(0);
	}

	@Test
	public void TititJestPodzielneTest() {
		assertTrue(kontrakt.Titit(5));
	}

	@Test
	public void TititNieJestPodzielneTest() {
		assertFalse(kontrakt.Titit(10));
	}
}

package mavenTest.Zadanie23;

import static org.junit.Assert.*;
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
	public void hulajTest() throws NieudanyPsikusException {
		int oczekiwana = kontrakt.HultajChochla(37);
		int wynik = 73;
		assertThat(oczekiwana, is(wynik));
		System.out.println("test dla 2 cyfr:" + oczekiwana);
	}

	@Test
	public void hulajTest3() throws NieudanyPsikusException {
		int oczekiwana = kontrakt.HultajChochla(123);
		// 123=> 132 213 321
		assertThat(oczekiwana, anyOf(is(132), is(213), is(321)));
		System.out.println("test dla 3 cyfr:" + oczekiwana);
	}

	@Test
	public void hulajTest4() throws NieudanyPsikusException {
		int oczekiwana = kontrakt.HultajChochla(1234);
		// 1234=> 1243 1432 4231 1324 3214 2134
		assertThat(
				oczekiwana,
				anyOf(is(1243), is(1432), is(4231), is(1324), is(3214),
						is(2134)));
		System.out.println("test dla 4 cyfr:" + oczekiwana);
	}

	@Test
	public void nieudanyPsikus() throws NieudanyPsikusException {
		boolean sprawdz = false;
		try {
			kontrakt.HultajChochla(4);
		} catch (NieudanyPsikusException e) {
			sprawdz = true;
		}
		assertTrue(sprawdz);
	}

	@Test
	public void HultajChochlaWyrzucaWyjatek_JednaCyfra() {
		try {
			kontrakt.HultajChochla(2);
			fail("Metoda nie dziala");
		} catch (NieudanyPsikusException e) {
			assertTrue(true);
		}
	}

	@Test(expected = NieudanyPsikusException.class)
	public void HultajChochlaMaJednaCyfre() throws NieudanyPsikusException {
		kontrakt.HultajChochla(1);
	}

	@Test
	public void NieksztaltekCzyZwrociArgumentTest() {
		int wartosc = kontrakt.Nieksztaltek(124);
		assertThat(wartosc, is(124));
	}

	@Test
	public void NieksztaltekCzyZamieniliczbe3Test() {
		int wartosc = kontrakt.Nieksztaltek(345);
		assertThat(wartosc, is(845));
	}

	@Test
	public void NieksztaltekCzyZamieniliczbe7Test() {
		int wartosc = kontrakt.Nieksztaltek(742);
		assertThat(wartosc, is(142));
	}

	@Test
	public void NieksztaltekCzyZamieniliczbe6Test() {
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
		assertFalse(kontrakt.Titit(8));
	}
}

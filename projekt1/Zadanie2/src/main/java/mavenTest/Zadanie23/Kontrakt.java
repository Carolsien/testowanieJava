package mavenTest.Zadanie23;

import java.util.Random;

public class Kontrakt implements Psikus {
	public int liczba;

	public Integer CyfroKrad(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer HultajChochla(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer Nieksztaltek(Integer liczba) {
		int ileCyfrDoZamiany = 0;
		for (char cyfra : liczba.toString().toCharArray()) {
			if (cyfra == '3' || cyfra == '6' || cyfra == '7')
				ileCyfrDoZamiany++;
		}
		if (ileCyfrDoZamiany == 0)
			return liczba;
		Random losowy = new Random();
		int doZamiany = losowy.nextInt(ileCyfrDoZamiany);
		String wynik = "";
		int pomoc = 0;
		for (int i = 0; i < liczba.toString().length(); i++) {
			char cyfra = liczba.toString().charAt(i);
			if (cyfra == '3' || cyfra == '6' || cyfra == '7') {
				if (pomoc == doZamiany) {
					switch (cyfra) {
					case '3':
						cyfra = '8';
						break;
					case '7':
						cyfra = '1';
						break;
					case '6':
						cyfra = '9';
						break;
					}
				}
				pomoc++;
			}
			wynik += cyfra;
		}
		return Integer.parseInt(wynik);
	}

	// zamienia liczbę na dowolną całkowitą z przedziału <0,liczba)
	public Integer Heheszki(Integer liczba) {
		if (liczba <= 0) {
			throw new IllegalArgumentException();
		} else {
			Random losowy = new Random();
			int wynik = losowy.nextInt(liczba);
			return wynik;
		}
	}

	// sprawdza, czy liczba jest podzielna przez liczba_dziel.
	public boolean Titit(Integer liczba_dziel) {
		if (liczba_dziel == 0) {
			throw new IllegalArgumentException();
		} else {
			if (liczba % liczba_dziel == 0) {
				return true;
			} else {
				return false;
			}
		}
	}

}

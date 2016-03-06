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
		// TODO Auto-generated method stub
		return null;
	}

	//zamienia liczbę na dowolną całkowitą z przedziału <0,liczba)
	public Integer Heheszki(Integer liczba) {
		if(liczba <= 0){
			throw new IllegalArgumentException();
		} else {
			Random losowy = new Random();
			int wynik = losowy.nextInt(liczba);
			return wynik;
		}
	}

	//sprawdza, czy liczba jest podzielna przez liczba_dziel.
	public boolean Titit(Integer liczba_dziel) {
		if(liczba_dziel == 0){
			throw new IllegalArgumentException();
		} else {
			if(liczba % liczba_dziel == 0 ){
				return true;
			} else {
				return false;	
			}
		}
	}

}

package mavenTest.Zadanie23;

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

	public Integer Heheszki(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

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

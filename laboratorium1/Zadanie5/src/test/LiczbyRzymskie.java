/*
Napisz klasę LiczbaRzymska, która będzie posiadała jedno prywatne pole zawierające
liczbę (zainicjalizowane w konstruktorze) i metodę toString(), która będzie zwracała tę samą liczbę
zapisaną w rzymskim systemie zapisywania liczb. Przed implementacją metody toString() zastanów
się jak powinna zachować się ta klasa w różnych przypadkach np. gdy w konstruktorze podano liczbę
ujemną. Zaimplementuj klasę testującą i odpowiednie przypadki testowe. W tym momencie testy
oczywiście zakończą się niepowodzeniem. Zaimplementuj metodę toString() i uruchom ponownie
testy.
 */
package test;

public class LiczbyRzymskie {
	private int liczba;

	public LiczbyRzymskie(int liczba){
		if (liczba <= 0){
			throw new IllegalArgumentException();
		}
		
		this.liczba = liczba;
	}

	public String toString() {
			String rzymska = "";
			int liczby[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
			String rzym[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
			int n=liczba;
			for(int i = 0; liczba > 0; i++){
				n = liczba/liczby[i];
				if ((liczba > 0) && (liczba <= 3999)) {
					for (int j = 1; j <= n; j++) {
						rzymska = rzymska + rzym[i];
					}
				}
				liczba = liczba % liczby[i];
			}
			return rzymska.toString();
		}
	}


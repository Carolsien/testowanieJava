/* Napisz klasę NWD, która będzie zawierała metodę:
int nwd(int a, int b)
Napisz klasę NWDTest, która będzie klasą testującą dla klasy NWD. Zaplanuj i zaimplementuj
odpowiednie przypadki testowe (sprawdzające poprawność wykonywanych operacji). Skorzystaj z
różnych asercji. Metoda NWD ma liczyć największy wspólny dzielnik (algorytm Euklidesa)
*/
package test;

public class Nwd {
	int nwd(int a, int b){
		if( a == 0 && b == 0){
			throw new IllegalArgumentException();
		}
		if( a < 0 || b < 0){
			throw new IllegalArgumentException();
		}
		if(b == 0){
			return a;
		} else{
			return nwd(b, (a % b));
		}
	}
	
}

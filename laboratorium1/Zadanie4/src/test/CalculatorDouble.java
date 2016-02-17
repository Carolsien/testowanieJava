/*
Napisz klasę Calculator, która będzie działała analogicznie do tej z zadania 2, ale
będzie wykonywała operacje na liczbach typu double. Napisz klasę CalculatorTest (zwróć uwagę
na możliwe błędy w zaokrągleniach, jak sobie z tym poradzić?).
 */

package test;

public class CalculatorDouble {

		public double add(double n1, double n2){
			return n1 + n2;
		}
		
		public double sub(double n1, double n2){
			return n1 - n2;
		}
		
		public double multi(double n1, double n2){
			return n1 * n2;
		}
		
		public double div(double n1, double n2){
				return n1 / n2;
		}
		
		public boolean greater(double a, double b){
			if( a > b ) {
				return true;
			} else {
				return false;
			}
		}
}
/*
Utwórz projekt MAVEN z zadania 2 labolatorium 2 (klasa stos). 
Stos ma być reprezentowany poprzez Listę. 
Dla prostoty wrzucamy liczby całkowite.
Rozpatrz następujące przypadki:
1. Jaka jest wartość IsEmpty() na początku utworzenia stosu?
2. Metodą push włóż element, następnie metodą top sprawdź wiele razy, czy wyszedł ten samelement.
3. Poprawność działania metody pop.
4. Wrzucenie wartości największej i najmniejszej na stosie.
5. I inne ...
 */

package mavenTest.Stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List<Integer> stack;

	public MyStack() {
		stack = new ArrayList<Integer>();
	}

	public MyStack(List<Integer> list) {
		stack = list;
	}

	public boolean IsEmpty() {
		return stack.size() == 0;
	}

	public void MyPop() {
		if (stack.isEmpty()) {
			throw new NullPointerException();
		} else {
			stack.remove(stack.size() - 1);
		}
	}

	public void MyPush(int elem) {
		stack.add(elem);
	}

	public int MyTop() {
		if (stack.isEmpty()) {
			throw new NullPointerException();
		}
		return stack.get(stack.size() - 1);
	}

}

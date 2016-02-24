/*
 Napisać klasę MyStack implementujący stos. Zaimplementować podstawowe operację
na stosie:
MyPush (wkładanie na stos)
MyPop (zdejmowanie ze stosu)
IsNull (pusty stos)
MyTop (wypisanie szczytu stosu)
Przy pomocy biblioteki Hamcrest oraz JUnit przetestować klasę MyStack
 */

package test;

import java.util.*;

/* pojedynczy element */
class Elem {
	int wartosc;
	Elem next;

	/* konstruktor */
	public Elem(int x, Elem n) {
		next = n;
		wartosc = x;
	}

	/* zwracam wskzaznik na nastepny obiekt */
	public Elem getNext() {
		return next;
	}

	/* zwracam przechowywana wartosc */
	public int getWartosc() {
		return wartosc;
	}
}

public class MyStack {

	/* wierzcholek stosu */
	Elem start;

	MyStack() {
		start = null;
	}

	/* zwracam wartosc wierzcholka */
	public Elem myTop() {
		return start;
	}

	/* dodaje element do stosu */
	public void myPush(int x) {
		Elem temp = new Elem(x, start);
		start = temp;
	}

	/* sciagam element ze stosu */
	public void myPop() {
		if (start != null) {
			start = start.getNext();
		} 

	}
	
	public boolean isNull(){
		if(start == null){
			return true;
		}else {
			return false;
		}
	}

}


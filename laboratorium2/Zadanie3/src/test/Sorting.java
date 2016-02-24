/*
 Używając dowolnej metody sortowania napisać klasę Sorting, 
 która będzie zawierała tablicę o nazwie table oraz metodę SortArray 
 (Sortowanie rosnące tablicy)
  następnie przetestować klasę Sorting przy użyciu JUnit oraz biblioteki Hamcrest. 
  Rozważ różne przypadki
 */

package test;

public class Sorting {

	Integer[] table;

	public Sorting(Integer[] tab) {
		table = tab;
	}

	public void bubbleSort() {
		if (table == null)
			throw new IllegalArgumentException();
		if (table.length == 0)
			throw new NullPointerException();
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length - 1; j++) {
				if (table[j] > table[j + 1]) {
					int temp;
					temp = table[j + 1];
					table[j + 1] = table[j];
					table[j] = temp;
				}
			}
		}
	}

}

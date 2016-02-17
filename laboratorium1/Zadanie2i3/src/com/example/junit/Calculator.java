/*
Napisz klasę Calculator, która będzie dostarczała pięć publicznych metod
int add(int a, int b)
int sub(int a, int b)
int multi(int a, int b)
int div(int a, int b)  (dzielenie całkowitoliczbowe)
boolean greater(int a, int b)
 */
package com.example.junit;

public class Calculator {

	public Calculator(){
		System.out.println("Calculator: " + this);
	}
	
	public int add(int n1, int n2){
		return n1 + n2;
	}
	
	public int sub(int n1, int n2){
		return n1 - n2;
	}
	
	public int multi(int n1, int n2){
		return n1 * n2;
	}
	
	public int div(int n1, int n2){
			return n1 / n2;
	}
	
	public boolean greater(int a, int b){
		if( a > b ) {
			return true;
		} else {
			return false;
		}
	}
}

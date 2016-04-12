
package mavenTest.Stack1;

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

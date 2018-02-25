/*
 * Emily Blanford
 * 2/24/2018
 * Refactoring deliverable1 to declutter main
 * Created method to perform task
 * Added Validator class to get correct user input
 */

package preWork;

import java.util.Scanner;
import java.util.Stack;

public class Deliverable1 {
	public static void main(String[] args) {
		// Scanner and two stacks
		Scanner scan = new Scanner(System.in);
		Stack<Integer> firstNum = new Stack<Integer>();
		Stack<Integer> secondNum = new Stack<Integer>();

		// Collects user input, with validation and stores as stacks
		firstNum = Validator.getStack(scan, "Please enter an integer greater than zero: ", 0);
		secondNum = Validator.getStack(scan, "Please enter another integer of the same length: ", 0, firstNum);

		// Outputs true or false
		System.out.println("\n" + digitsEqual(firstNum, secondNum));

		scan.close();
	}

	// Method to determine if the each digit sum equals the next
	public static boolean digitsEqual(Stack<Integer> first, Stack<Integer> second) {
		int sum = first.pop() + second.pop();
		while (first.size() != 0) {
			int nextSum = first.pop() + second.pop();
			if (sum != nextSum)
				return false;
			sum = nextSum;
		}

		return true;
	}

}

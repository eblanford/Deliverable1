package preWork;

import java.util.Scanner;
import java.util.Stack;

public class Deliverable1 {
	public static void main(String[] args) {
		// Scanner
		Scanner scnr = new Scanner(System.in);
		// User Inputs
		int userInt1 = 0;
		int userInt2 = 0;
		// Sum Holders
		int sumFirst;
		int sumSecond;
		// Outcome
		boolean outcome = true;
		// Arrays to put each digit into, stack uses first in last out logic
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		// Collects two integers from user, returns error if incorrect input
		System.out.println("Enter an integer: ");
		userInt1 = scnr.nextInt();
		System.out.println("Enter another integer with the same amount of digits: ");
		userInt2 = scnr.nextInt();
		
		// Separates each digit and stores in an array, MAKE METHOD??
		while (userInt1 > 0) {
		    stack1.push(userInt1 % 10);
		    userInt1 = userInt1 / 10;
		}
		while (userInt2 > 0) {
			stack2.push(userInt2 % 10);
			userInt2 = userInt2 / 10;
		}

		// Checks that number of digits are the same & returns false if not
		if (stack1.size() == stack2.size()) {
			// Creates the first sum by removing from the front of the array
			sumFirst = stack1.pop() + stack2.pop();

			// Loops through until stack size is empty or sums do not equal
			while (stack1.size() != 0) {
			sumSecond = stack1.pop() + stack2.pop();
			if (sumFirst != sumSecond) {
					outcome = false;
					break;
				}
			sumFirst = sumSecond;
			}

		} else {
			outcome = false;
		}

		// Prints outcome
		System.out.println(outcome);

		// Closes scanner to remove warning
		scnr.close();
	}
}

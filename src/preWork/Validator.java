package preWork;

import java.util.Scanner;
import java.util.Stack;

public class Validator {

	// Integer validation
	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	// Validates for an integer with a minimum value
	public static int getInt(Scanner sc, String prompt, int min) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i <= min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else
				isValid = true;
		}
		return i;
	}

	// Validator that takes in an integer from the user and returns a stack
	public static Stack<Integer> getStack(Scanner sc, String prompt, int min) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = getInt(sc, prompt, 0);
		while (i > 0) {
			stack.push(i % 10);
			i /= 10;
		}
		return stack;
	}

	// Same as getStack except that it takes in another stack and checks that the
	// sizes match
	public static Stack<Integer> getStack(Scanner sc, String prompt, int min, Stack<Integer> compare) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean isValid = false;
		while (isValid == false) {
			stack = getStack(sc, prompt, min);
			if (stack.size() != compare.size())
				System.out.println("Error, please enter an integer with " + compare.size() + " digit(s)");
			else
				isValid = true;
		}

		return stack;
	}

}


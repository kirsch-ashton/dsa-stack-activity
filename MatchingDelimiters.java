import java.util.Scanner;
import java.util.Stack;

/*
    Description: Checks whether delimiters are properly matched and nested using a stack.
    Programmed by: Kurt Dwayne C. Gulle BSIT 48079 Data Structures and Algorithms
    Last Modified: October 29, 2026
    Version: 1.0
    [Acknowledgements:
        https://www.youtube.com/watch?v=5VQ2Nwq75zk.
        https://www.geeksforgeeks.org/dsa/extract-substrings-between-any-pair-of-delimiters/
        https://www.youtube.com/watch?v=pUvkt6ENQeI
    ]
*/

public class MatchingDelimiters {

    public static boolean checkDelimiters(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);

                System.out.println("\nRead: " + ch);
                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Operation: INVALID");
                    System.out.println("Reason: Closing delimiter has no matching opening delimiter.");
                    System.out.println("Stack: " + stack);
                    return false;
                }
                char top = stack.peek();
                System.out.println("Operation: PEEK " + top);
                boolean matches = (ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{');
                if (!matches) {
                    System.out.println("Operation: INVALID");
                    System.out.println("Reason: Mismatched delimiters. Found " + ch + " while the top opening delimiter is " + top + ".");
                    System.out.println("Stack: " + stack);
                    return false;
                }
                stack.pop();
                System.out.println("Operation: POP " + top);
                System.out.println("Stack: " + stack);
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("\nOperation: INVALID");
            System.out.println("Reason: Unmatched opening delimiter remains.");
            System.out.println("Stack: " + stack);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a delimiter sequence or expression: ");
        String input = scanner.nextLine();

        System.out.println("\n========== RESULT ==========");
        System.out.println(checkDelimiters(input) ? "Valid" : "Invalid");

    }
}


import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		String inputs = sc.next();
		int res = 0;
		for (int i = 0; i < inputs.length(); i++) {
			char input = inputs.charAt(i);
			if (input == '(') {
				st.push(input);
			} else {
				if (!st.isEmpty()) {
					st.pop();
					if (inputs.charAt(i - 1) == '(') {
						res += st.size();
					} else {
						res += 1;
					}
				}
			}

		}// res 더해감
		System.out.println(res);
		sc.close();
	}//main 
}

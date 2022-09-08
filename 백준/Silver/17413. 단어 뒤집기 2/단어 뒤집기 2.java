
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		String sent = br.readLine();
		int i = 0;
//		System.out.println(sent.length());
		while (i < sent.length()) {
//			System.out.println(sent.charAt(i));
			// <일 때
			if (sent.charAt(i) == '<') {
				sb.append('<');
				i += 1;
				while (sent.charAt(i) != '>') {
					sb.append(sent.charAt(i));
					i++;
				}
			}
			// 공백일 때
			else if (sent.charAt(i) == ' ') {
//				System.out.println(i);
				sb.append(' ');
				i++;
			}
			else if (sent.charAt(i)=='>') {
				sb.append('>');
				i++;
			}
			// 문자일 때
			else {
//				System.out.println(i);
//				System.out.println(sent.charAt(i));
				while (i<sent.length() && sent.charAt(i) != ' ' && sent.charAt(i) != '<' && sent.charAt(i) != '>') {
					stack.push(sent.charAt(i));
//					System.out.println(stack.toString());
					i++;
				}
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}

		}
		System.out.println(sb);
	}
}

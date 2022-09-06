
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String word = br.readLine();
		int N = Integer.parseInt(br.readLine());

		Stack<String> front = new Stack<>();
		Stack<String> back = new Stack<>();
		for (int i = 0; i < word.length(); i++) {
			front.push(word.substring(i, i + 1));
		}

		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("L")) {
				if (!(front.isEmpty())) {
					back.push(front.pop());
				}
			} else if (order.equals("D")) {
				if (!(back.isEmpty())) {
					front.push(back.pop());
				}
			} else if (order.equals("B")) {
				if (!(front.isEmpty())) {
					front.pop();
				}
			} else {
				String a = st.nextToken();
				front.push(a);
			}
		}
		while(!front.isEmpty()) {
			sb.append(front.pop());
		}
		sb.reverse();
		while(!back.isEmpty()) {
			sb.append(back.pop());
		}
//		for (int i=0; i<back.size();i++) {
//			sb.append(back.pop());
//		}
		System.out.println(sb);
//		System.out.println(front.toString());
//		System.out.println(back.toString());

	}// main
}

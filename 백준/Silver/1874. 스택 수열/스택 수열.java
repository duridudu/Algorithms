
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Stack<Integer> st = new Stack<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			q.offer(sc.nextInt());
		}

		StringBuilder sb = new StringBuilder(200000);
		int num = 1;
		Loop1:
		while (num <= n) {
			st.push(num);
			sb.append("+\n");
//			System.out.println("+");
//			System.out.println(st.toString());
//			System.out.println(q.toString());
			if (!(st.empty()) && !(q.isEmpty())) {
				while (st.peek().equals(q.peek())) {
//					System.out.println(st.peek());
//					System.out.println(q.peek());
//					System.out.println("size " +st.size());
					st.pop();
					q.poll();
					sb.append("-\n");
//					System.out.println("-");
					if (st.size()==0) {
//						sb.append("-\n");
						break;
					}
					
//					else {
//						if (st.empty()) {
//							sb.setLength(0);
//							sb.append("NO");
//							break Loop1;
//						}
//					}
				
				}
			}
			num++;
		} // while
		if (! q.isEmpty()) {
			sb.setLength(0);
			sb.append("NO");
//			System.out.println("NO");
		}
		System.out.println(sb);
	}

}

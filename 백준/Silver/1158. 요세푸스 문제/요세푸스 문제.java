
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		sb.append("<");
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		} // 큐에 1부터 N까지 저장
		
		while (!(q.isEmpty())){
			for (int i=1;i<K;i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}//main
}

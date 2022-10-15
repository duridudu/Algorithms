import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 초기에 입력받을 배열이다여 
		Integer[] arr = new Integer[N];
		// 덱에 넣어서 처리해줄거다여 
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 내림차순 정렬해서 큰것부터 곱할거에여 
		Arrays.sort(arr, Collections.reverseOrder());
		// 정렬된거 덱에도 넣어준다여 
		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
		}
		// 누적해서 더해갈 변수에여 
		int res = 0;
		
		// 수열의 양수들 먼저 더할거에여 0보다클때까지 더해주자여 + 빈 덱 아닐때~~ 
		while (!q.isEmpty() && q.peek() > 0) {
			// 하나 뽑은걸 arri로 저장하구 
			int arri = q.poll();
			// 그 옆에거가 빈거 아니고, 0보다 큰거면 곱해서 더하는게 이득이다여
			if (!q.isEmpty() && q.peek() > 0  && q.peek() != 1) {
				res += arri * q.peek();
				// 더한애는 빼주자여 
				q.poll();
			} else {
				// 근데 옆에 애가 비었거나 0보다 작거나 같으면여 그냥 지금 애만 답에 더해줘여 
				res += arri;
			}
		}
		
		// 이제 음수 영역을 볼 차례다여 
		while (!q.isEmpty()) {
			// 음수일때는 젤 뒤에서부터 곱할거에여 음수니까 절댓값 큰거 곱할수록 크니까여 
			int arri = q.pollLast();
			if (!q.isEmpty()) {
				// 지금 뽑힌애랑 그 옆에 애 곱해줘여 
				res += arri * q.peekLast();
				q.pollLast();
			} else {
				// 비어있으면 그냥 답에 지금 애만 더해줘여 
				res += arri;
			}
		}
		System.out.println(res);
	}
}


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] arr;
	static int[] numLinked; // i번째 학생보다 작은 학생들의 수 기록 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new ArrayList[N + 1];
		numLinked=new int[N+1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList();
		}
		for (int i = 0; i < M; i++) {
			int shorter = sc.nextInt();
			int taller = sc.nextInt();
			// 작은애 다음에 큰애가 와야함
			arr[shorter].add(taller);
			// 큰애에 딸린 작은애들 개수 (작아 리스트) 하나 up
			numLinked[taller] += 1;
		} // arr

		// 위상정렬 시작
		Queue<Integer> q = new LinkedList<>();
		// 학생 수만큼 반복
		for (int i = 1; i <= N; i++) {
			// i번째 학생보다 작다고 기록된 애가 한명도 없으면 큐에 넣음
			if (numLinked[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			// 큐에 있는 학생 번호 뽑아서 결과에 추가 
			int n = q.poll();
			sb.append(n).append(' ');
			// i번째 학생보다 큰 학생들을 몽땅 순회할 것임. 
			for (int taller : arr[n]) {
				// i번째 학생보다 큰 학생들의 작아리스트를 하나 줄임 
				numLinked[taller]--;
				// 이 학생의 작아 리스트가 0명이면 얘 방문 끝난 것이기 때문에 큐에 넣어줌 
				// 그리고 이 학생보다 큰 학생으로 넘어감 
				if (numLinked[taller] == 0) {
					q.add(taller);
				}
			}
		} // while
		System.out.println(sb);
	}
}

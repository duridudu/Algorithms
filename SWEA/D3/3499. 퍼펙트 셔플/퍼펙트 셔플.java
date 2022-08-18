import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			Queue<String> first = new LinkedList<>();
			Queue<String> second = new LinkedList<>();
			
			String arr[] = new String[N];
			String res[] = new String[N];
			// 이름들 저장
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();
			}
            
            // 짝수개이면 - 두 큐에 앞/뒤 나눠서 저장
			if (arr.length %2 ==0) {
				for (int i=0; i<N/2; i++) {
					first.add(arr[i]);
				}
				for (int i=N/2;i<N;i++) {
					second.add(arr[i]);
				}
			}
            //홀수개이면
			else {
				for (int i=0; i<=N/2;i++) {
					first.add(arr[i]);
				}
				for (int i=N/2+1; i<N;i++) {
					second.add(arr[i]);
				}
			}
			
            // 두 큐에서 인덱스 홀짝별로 poll
			for (int i =0; i<N;i++) {
				if (i%2==0) {
					res[i]=first.poll();
				}
				else {
					res[i] = second.poll();
				}
			}
			System.out.printf("#%d ",tc);
			for (int i=0; i<N;i++) {
				System.out.printf("%s ",res[i]);
			}
			System.out.println();
		} // TC
	}// main
}

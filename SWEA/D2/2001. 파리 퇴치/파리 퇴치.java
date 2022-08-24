
import java.util.Scanner;

public class Solution {
	static int [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			arr= new int[N][N];
			for (int i=0; i<N;i++) {
				for (int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}// arr
			
			int max=0;
			// 전체 배열 돌면서 M*M만큼의 합 구할것 
			for (int i=0;i<=N-M;i++) {
				for (int j=0;j<=N-M;j++) {
					int sum=0;
					for (int a=0;a<M;a++) {
						for (int b=0;b<M;b++) {
							sum+=arr[i+a][j+b];
						}
					}// 현재 좌표에 대한 파리채 끝 
					max=Math.max(max, sum);
				}
			}
			System.out.println("#"+tc+" "+max);
		}//tc
		sc.close();
	}//main
}


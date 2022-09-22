
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		} // arr

		Arrays.sort(arr, Collections.reverseOrder());
		int cnt = 0;
		int i = 0;
		int val = K;
		int temp;
		int mod = 1;
		while (mod != 0) {
			if (arr[i] <= val) {
				temp = val / arr[i];
				mod = val % arr[i];
				cnt += temp;
				val = mod;
			}
			i++;
		}
		sb.append(cnt);
		System.out.println(sb);
	}//main 
}

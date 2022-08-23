
import java.util.Scanner;

public class Solution {
	// 계속 쓰이고 메소드에서도 쓰이는 변수들은 static으로 해놓아야 편함 
	// 과거의 나 - 계속 인자로 넘겨줬음 불편 
	static char[] tree;
	static int N;
	static StringBuilder sb; // 스트링빌더를 써보자 
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for (int tc=1;tc<=10;tc++) {
			N=sc.nextInt();
			tree = new char[N+1];
			
			for (int i=1; i<=N;i++) {
				sc.next();
				// 한 단어 받을때는 charAt에 0 넣으면 됨. 
				tree[i]=sc.next().charAt(0);
				// 좌 혹은 우에 자식 있으면 그냥 날린다는거야 
				if (i*2<=N) {
					sc.next();
				}
				if (i*2+1<=N) {
					sc.next();
				}
			}
			sb=new StringBuilder();
			sb.append("#").append(tc).append(" ");
			inOrder(1); //1만 넣고 시작하면 자기 혼자 증식 
			System.out.println(sb.toString());
			
		}
		
	}

	private static void inOrder(int i) {
		// 1부터 N까지 계속 순회 
		if (i <= N) {
			inOrder(i*2); // 왼자가 이제 들어가서 i 돼서 출력됨 그리고 왼자의 왼자가 또 들어감 
			sb.append(tree[i]);
			inOrder(i*2+1);
		}
		
	}
}

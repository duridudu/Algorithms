import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String msg) {
        // HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> dict = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        
        
        // 색인번호 1부터 시작하므로 인덱스 0값 임의로 채워줌 
        dict.add("empty");
        
        // array list에 알파벳 추가 
        for (int i=0; i<26;i++){
            char tmp2 = (char)('A'+i);
            dict.add(String.valueOf(tmp2));
        }
        // queue에 주어진 메세지 추가 
        for (int i=0; i<=msg.length()-1; i++){
            q.add(msg.substring(i,i+1));
        }
        // int num = 26;
        while(!q.isEmpty()){
            String proc = "";
            for (String a:q){
                proc+=a;
            }
            // System.out.print("now proc is "+proc+"\n");
            // 사전에 등록된 문자로 시작되면 출력하고 종료 
            for (int i=dict.size()-1; i>=0; i--){
                String start = dict.get(i);
                // System.out.print("now in dic is "+start+"\n");
                if (proc.startsWith(start)){
                    // 색인번호 출력 
                    ans.add(i);
                    // 사전에 w+c만큼 추가하고 큐에서 삭제
                    String now = "";
                    for (int j=0; j<start.length();j++){
                        now += q.peek();
                        q.poll();
                    }
                    // w+c의 c 부분 
                    if (!q.isEmpty()){
                        now+=q.peek();
                    }
                    // System.out.print("사전에 등록되는 단어는 "+now+"\n");
                    dict.add(now);
                    break;
                }
                if (i==0){ // 사전에 등록된 문자가 아니면 
                   String now2 = q.poll();
                    ans.add(dict.indexOf(now2));
                    if(!q.isEmpty()){
                        now2 += q.peek();
                    }

                    // System.out.print("사전에 등록되는 단어는 "+now2+"\n");
                    dict.add(now2); 
                        }
            }
        }
        int[] answer = new int[ans.size()];
        for (int i=0; i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}
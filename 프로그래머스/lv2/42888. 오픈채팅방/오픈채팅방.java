import java.util.*;



class Solution {
    // id와 상태를 저장할 클래스 -> 추후 이대로 출력만 하면 됨 (id에 따른 닉네임 변화는 해시맵에 저장)
    class Status{
        String id, stat;
        public Status(String id, String stat){
            this.id = id;
            this.stat = stat;
        }
    }
    
    public String[] solution(String[] record) {
        // 해시맵으로 아이디, 닉네임 저장 (닉네임 변할때마다 해당 아이디에 업데이트하면 유지 가능)
        HashMap<String, String> users = new HashMap<>();
        // Status 저장할 배열 
        ArrayList<Status> process = new ArrayList<>();
        
        for (int i=0; i<record.length; i++){
            String [] info = record[i].split(" ");
            // 입력 공백으로 쪼갠 후 상태, 아이디 저장 후 Status객체에 저장 
            String stat = info[0];
            String id = info[1];
            Status st = new Status(id, stat);
            // 입장이면 닉네임 같이 저장 후 users 맵과 process 객체에 정보, 상태 저장 
            if (stat.equals("Enter")){
                String nick = info[2];
                users.put(id, nick);
                process.add(st);
            }
            // 교체면 닉네임 업데이트 후 users 맵 업데이트 (process에는 등록 안해도 됨)
            else if (stat.equals("Change")){
                String nick = info[2];
                users.replace(id, nick);
            }
            // 나가는거면 users 업데이트 불필요, process에 상태 업데이트
            else{
                process.add(st);
            }
        }
        
        String[] answer = new String[process.size()];
        for (int i=0; i<process.size(); i++){
            // 상태 객체에서 아이디, 상태 불러온 후, 해시맵으로 그 아이디에 연결된 최신상태의 닉네임 불러옴 
            String nowId = process.get(i).id;
            String nowNick = users.get(nowId);
            String nowSt = process.get(i).stat;
            if (nowSt.equals("Enter")){
                answer[i] = nowNick+"님이 들어왔습니다.";
            }
            else if (nowSt.equals("Leave")){
                answer[i] = nowNick+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
from collections import deque

def solution(begin, target, words):
    answer = 0
    q=deque([begin])
    visited=[False]*len(words)
    if begin in words:
        words.remove(begin)
        
    while(q):     
        if q[0]==target:
            break
        now=q.popleft()
        for i in range(len(now)):
            temp_now = now[:i]+now[i+1:]
            temp=0
            ## 쪼각에 대해 다음 후보가 있는지 판단 
            for j in range(len(words)):
                temp_word=words[j][:i]+words[j][i+1:]
                if (temp_word==temp_now) and (visited[j]!=True) :
                    q.append(words[j])
                    temp+=1
                    visited[j]=True
                    if temp==1:
                        answer+=1
                    else:
                        answer-=1
    if len(q)==0:
        answer=0
        return answer
    return answer
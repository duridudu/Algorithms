from collections import deque
def solution(plans):
    answer = []
    keeps=[]
    for i in range(len(plans)):
        plans[i][1]=int(plans[i][1][:2])*60+int(plans[i][1][3:])
        plans[i][2]=int(plans[i][2])
    
    plans=sorted(plans,key= lambda x:(x[1],x[0],x[2]))
    left=0
    q=deque()
    
    for i in range(len(plans)):
        ## 나눠서 저장
        name, start, time=plans[i]
        while (q):
            _name, _time=q.pop()
            if left>=_time:
                left-=_time
                answer.append(_name)
            else:
                q.append((_name,_time-left))
                break
        q.append((name, time))
        if i<len(plans)-1:
            next_start=plans[i+1][1]
            left=next_start-start
    while q:
        _name, _=q.pop()
        answer.append(_name)
        
    return answer
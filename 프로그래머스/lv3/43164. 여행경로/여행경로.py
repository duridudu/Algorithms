from collections import deque
from collections import defaultdict

def solution(tickets):
    answer = deque()
    ## 항공권 모두 사용해야 함
    ## 가능한 경로 2개 이상이면 알파벳 순서 앞서는거
    ## 방문하는 공항 경로 리턴하기
    tickets=sorted(tickets, key=lambda x : (x[0],x[1]))
    
    ## 출발지에서 바로 도착지를 알 수 있도록 사전 형태로 변환
    dic=defaultdict(list)
    for i in range(len(tickets)):
        dic[tickets[i][0]].append(tickets[i][1])
    
    ## 알파벳 순 확인을 위해 정렬, pop으로 뽑을 것이기 때문에 내림차순
    for i in dic:
        dic[i]=sorted(dic[i], reverse=True)
        
    ## 일반 사전으로 변환
    dic=dict(dic)
    ## 키(출발지) 따로 확인용
    keys = dic.keys()
    ## 무조건 인천에서 시작하는걸로
    stack=["ICN"]
    print(dic)
    print(keys)
    while stack:
        ## 가장 나중에 들어간 것
        dt = stack[-1]
        print(dt)
        ## 출발지 목록에 없으면 스택에서 뺌
        if dt not in keys :
            answer.appendleft(stack.pop())
        ## dt에서 출발하는 티켓이 하나도 없으면  
        elif not dic[dt]:
            answer.appendleft(stack.pop())
        ## 그렇지 않으면 스택에 추가하고 사전에서 뺀다
        else :
            stack.append(dic[dt].pop())


    return list(answer)
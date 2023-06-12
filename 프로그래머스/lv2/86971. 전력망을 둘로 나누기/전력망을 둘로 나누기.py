from collections import deque, Counter

def bfs(a, tmp, n):
    visited=[False]*(n+1)
    q=deque([a])
    while(q):
        now=q.popleft()
        for k in range(len(tmp[now])):
            b=tmp[now][k]
            if visited[b] !=True:
                q.append(b)
                visited[b]=True
    return visited

## 다해보기
def solution(n, wires):
    answer = 10000000
    
    ## 끊을 수 있는 후보는 len(wires)개
    for i in range(len(wires)):
        tmp=wires[0:i].copy()
        tmp+=wires[i+1:].copy()
        ## 인접그래프용 빈 리스트
        graph=[[] for i in range(n+1)]
        ## 방문 체크
        visited=[False]*(n+1)
        for w in tmp:
            x,y=w
            graph[x].append(y)
            graph[y].append(x)
        ## 끊을 구간은 wires[i] 애들
        a,b=wires[i][0], wires[i][1]
        # print(a,b)
        # print(graph)
        ## 끊을 번호 중 하나 dfs해서 그 길이 혹은 len(wires)-dfs길이
        cnt=bfs(b, graph, n)
        cnt=Counter(cnt)
        temp=abs(cnt[True]-(cnt[False]-1))

        if temp<answer:
            answer=temp
        
    return answer
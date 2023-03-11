from collections import deque
# dfs : 시간초과
# def dfs(position,n,m,answer):
#     if position[0]==n-1 and position[1]==m-1:
#         answer+=1
    
#     visited[position[0]][position[1]]=False
#     for i in range(2):
#         r=position[0]+dx[i]
#         c=position[1]+dy[i]
#         if r<n and c<m and visited[r][c]!=True:
#             new=[r,c]
#             visited[r][c]=True
#             answer=dfs(new,n,m,answer)%1000000007
#     return answer
            
def solution(m, n, puddles):
    global dx,dy,visited
    # global answer
    answer = 0
    # bfs로 풀 경우 (시간 초과)
    # q=deque()
    # q.append([0,0])
    
    # dfs, bfs로 풀 경우 (시간 초과)
    # dx=[0,1]
    # dy=[1,0]
    # 방문 체크 필요할 때
    #visited = [[False]*m for i in range(n)]
    # 방문체크할 때
    #for p in puddles:
        #visited[p[1]-1][p[0]-1]=True
        
    # dp용 리스트 
    arr=[[0]*(m+1) for i in range(n+1)]
    
    # 물 잠긴 곳 리스트
    visited=[[0]*(m+1) for i in range(n+1)]
    # 인덱스 안쓰고 걍 이렇게 쪼개는게 더 간편
    for x,y in puddles:
        visited[y][x]=1
    # 초기값 1로 설정
    arr[0][1]=1
    # 문제 조건 따라서 1,1에서 시작
    for i in range(1,n+1):
        for j in range(1,m+1):
            # print(i,j)
            # print(arr)
            # 지금 자리가 물에 잠긴 곳이면 패스
            if visited[i][j]==1:
                # print("나 패스됐어~~")
                continue
            # 갈 수 있는 길이면 
            else:
                # 여기까지 오는 경로의 수 = 오른쪽+윗쪽 값
                arr[i][j]=(arr[i][j-1]+arr[i-1][j])%1000000007
                # print(arr[i][j])
        
    # dfs로 풀 경우 (시간 초과)    
    # answer=dfs([0,0],n,m,answer)%1000000007
    return arr[n][m]

# bfs 풀이    
#     while(q):
#         temp=q.pop()
#         visited[temp[0]][temp[1]]=False
        
#         if temp[0]==n-1 and temp[1]==m-1:
#             answer+=1
        
#         for i in range(2):
#             r=temp[0]+dx[i]
#             c=temp[1]+dy[i]
#             if r<n and c<m and visited[r][c]!=True:
#                 new=[r,c]
#                 q.append(new)
#                 visited[r][c]=True

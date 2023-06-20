from collections import deque
def solution(maps):
    answer = -1
    n=len(maps)
    m=len(maps[0])
    check=[]
    
    ## 상하좌우
    dx=[0,0,-1,1]
    dy=[1,-1,0,0]
    for i in range(len(maps)):
        ## 첨엔 여길 트루폴스로..
        check.append([0]*len(maps[0]))
    check[0][0]=1
    q=deque([(0,0)])
    while(q):
        qq=q.popleft()
        x=qq[0]
        y=qq[1]
        # print(x,y)
        
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
           ## 안 막혀있고, 길이 맞고, 방문한 적이 없다면
            if 0<=xx<n and 0<=yy<m and maps[xx][yy]==1 and check[xx][yy]==0:
                # print("나 방문했어~",xx,yy)
                check[xx][yy]=check[x][y]+1
                q.append([xx,yy])
                
    if check[n-1][m-1]==0:
        answer=-1
    else:
        answer=check[n-1][m-1]
    return answer

# def solution(maps):
#     answer = 123123123123123123123123
#     n=len(maps)
#     m=len(maps[0])
#     check=[]
    
#     ## 상하좌우
#     dx=[0,0,-1,1]
#     dy=[1,-1,0,0]
#     for i in range(len(maps)):
#         check.append([False]*len(maps[0]))
    
#     def dfs(x,y,length):
#         nonlocal answer
#         if x == len(maps[0])-1 and y == len(maps)-1:
#             if length < answer:
#                 answer = length
#         check[x][y]=True
#         for i in range(4):
#             xx=x+dx[i]
#             yy=y+dy[i]
#            ## 안 막혀있고, 길이 맞고, 방문한 적이 없다면
#             if 0<=xx<n and 0<=yy<m and maps[xx][yy]==1 and check[xx][yy]==False:
#                 # print("나 방문했어~",xx,yy)
#                 check[xx][yy]=True
#                 dfs(xx, yy, length+1)
    
#     dfs(0,0,1)
    
#     if answer == 123123123123123123123123:
#         return -1
#     else:
#         return answer
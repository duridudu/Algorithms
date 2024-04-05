import sys
from collections import deque

def bfs(x_start,y_start):
    queue=deque()
    queue.append([x_start,y_start])

    while queue:
        x,y=queue.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            #다음 좌표가 범위 밖이면 불가능. continue.
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            #다음 좌표가 이미 방문한 좌표면 할 필요 X. continue.
            if answer[nx][ny]!=-1:
                continue

            #아직 방문하지 않은 유효한 좌표면, 이전 좌표의 answer값에 1을 더한 것으로 값을 세팅하고 덱에 저장.
            answer[nx][ny]=answer[x][y]+1
            queue.append([nx,ny])


#메인 코드 부분
n,m=map(int, sys.stdin.readline().split()) #세로 n, 가로 m

#북동남서(변화율)
dx=[-1,0,1,0]
dy=[0,1,0,-1]

#지도 입력받기
myMap=[]
for i in range(n):
    myMap.append(list(map(int,sys.stdin.readline().split())))


#정답 배열 세팅하기
answer=[]
x_start,y_start=0,0 #여기에 출발점을 저장할 것임.
for i in range(n):
    answer.append([])
    for j in range(m):
        if myMap[i][j]==2: #출발점이면 이 좌표를 기억하고 0으로 표시.
            x_start, y_start=i, j #출발점 좌표!
            answer[i].append(0)
        elif myMap[i][j]==1: #갈 수 있는 땅이면 -1로 표시.
            answer[i].append(-1)
        else: #갈 수 없는 땅이면 0으로 표시.
            answer[i].append(0)

#출발점에서 BFS 시작.
bfs(x_start,y_start)

#정답 배열 출력
for i in range(n):
    for j in range(m):
        print(answer[i][j], end=' ')
    print()
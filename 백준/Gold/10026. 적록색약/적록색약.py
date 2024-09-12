from collections import deque
import copy

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(i,j,v,cc):
  q = deque()
  ## 큐에 처음 들어온 인자 저장
  q.append((i,j))
  ## 방문처리
  v[i][j] = True
  ## 모든 큐를 돌 때까지 
  while(q):
    ## 맨 앞에 있는 인덱스를 빼서 
    x,y = q.popleft()
    color = cc[x][y]
    ## 이 칸과 연결된 상하좌우 칸 검사!
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      
      if nx<0 or nx>=n or ny<0 or ny>=n:
        continue
        
      c = cc[nx][ny]
      if not v[nx][ny] and c == color : 
          q.append((nx,ny))
          v[nx][ny] = True
      
      
n = int(input())
colors = []

### 기본 False(방문 안 함 상태)
v1 = [[False]*n for _ in range(n)]
v2 = [[False]*n for _ in range(n)]

answer = 0
answer2 = 0

for _ in range(n):
  colors.append(list(input()))

colors2 = copy.deepcopy(colors)

## 적록색약인간을 위한 조치.
## G를 몽땅 R로 바꾼다.
for i in range(n):
  for j in range(n):
    if colors2[i][j] == "G":
      colors2[i][j] = "R"

## 일반인간
for i in range(n):
  for j in range(n):
    if not v1[i][j]:
        bfs(i,j,v1,colors) 
        answer+=1
      
## 적록색약인간
for i in range(n):
  for j in range(n):
    if not v2[i][j]:
      bfs(i,j,v2,colors2)
      answer2 += 1
      
print(answer,answer2)
        
  
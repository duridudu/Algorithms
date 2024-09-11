import math
from collections import deque

dx = [0,0,1,-1]
dy = [1,-1,0,0]

N,M,K = map(int,input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
foja = 0
g_foja = 0

def bfs(i,j):
  queue = deque()
  queue.append((i,j))
  lst[i][j] = 1
  temp = 1
  while(queue):
    now  = queue.popleft()
    x = now[0]
    y = now[1]
    
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or nx >= N or ny < 0 or ny >= N:
        continue

      if lst[nx][ny] == 0:
        queue.append((nx,ny))
        lst[nx][ny] = 1
        temp += 1
  return temp
for i in range(N):
  for j in range(N):
    if lst[i][j] != 1:
      foja = bfs(i,j) 
      g_foja += (math.ceil(foja/K))
      #print(i,j,foja,g_foja)
      
if g_foja<=M and g_foja != 0:
  print("POSSIBLE")
  print(M-g_foja)
else:
  print("IMPOSSIBLE")
        
  
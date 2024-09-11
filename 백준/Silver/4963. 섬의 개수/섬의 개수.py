import sys
sys.setrecursionlimit(10**6)

dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, 1, -1, -1, -1, 1, 1]

def dfs(i,j):
  jido[i][j] = 0
  for k in range(8):
    nx = i + dx[k]
    ny = j + dy[k]
    if nx<0 or nx>=h or ny<0 or ny>=w :
      continue
    if jido[nx][ny] == 1:
        dfs(nx,ny)
      
while(True):
  w,h = map(int,input().split())
  if w==0 and h==0:
    break
  jido = []
  
  for _ in range(h):
    jido.append(list(map(int, input().split())))
  answer = 0

  for i in range(h):
    for j in range(w):
      if jido[i][j] != 0:
        dfs(i,j) 
        answer+=1
  print(answer)
        
  
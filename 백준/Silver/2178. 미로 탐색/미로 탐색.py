from collections import deque
n,m=map(int, input().split())
map=[]
for i in range(n):
   temp=[]
   tt=list(input())
   for j in range(m):
      temp.append(int(tt[j]))
   map.append(temp)

dx=[0,0,-1,1]
dy=[-1,1,0,0]

q=deque([(0,0)])
check=[[0 for i in range(m)] for row in range(n)]
check[0][0]=1

while(q):
   now=q.popleft()
   x=now[0]
   y=now[1]
   for i in range(4):
      xx=x+dx[i]
      yy=y+dy[i]
      if 0<=xx<n and 0<=yy<m and map[xx][yy]==1 and check[xx][yy]==0:
         # print(xx,yy)
         check[xx][yy]=check[x][y]+1
         q.append((xx,yy))

print(check[n-1][m-1])


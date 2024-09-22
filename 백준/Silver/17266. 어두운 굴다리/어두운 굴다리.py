import sys
input = sys.stdin.readline

## 길이
N = int(input())
## 개수
M = int(input())
## 가로등 위치
lights = [0]*M
pos = list(map(int,(input().split())))
for i in range(M):
  lights[i] = pos[i]

start = 0
end = N
h=0
answer=[]

def is_possible(lights,h):
  ## 첫번째 경우
  if  (lights[0]-h  > 0) :
      return False
  ## 마지막 가로등 경우
  if (lights[M-1]+h < N) :
      return False
  ## 중간 가로등 경우는 다음 가로등이랑 연결 가능한지만 보면 된다.
  for i in range(0,M-1): 
    if lights[i]+h < lights[i+1]-h:
      return False
  return True
    
while(start<=end):
  h = (start+end)//2
  possible = is_possible(lights, h)
  ## 다음 가로등 설치 가능하면 쭉쭉 넘어간다.
  ## 다음 h를 어떻게 바꿀지 결정
  ## [1] 가로등이 짧아서 위 for문 중간에 멈췄으면, 늘려준다.
  if not possible :
    start = h+1
  ## [2] 이번 h에서 가능했던거면 길이를 더 줄여본다. 
  else:
    answer.append(h)
    end = h-1
print(min(answer))
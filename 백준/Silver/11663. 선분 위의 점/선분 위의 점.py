import sys
si = sys.stdin.readline

N,M = map(int, si().split())
dots = list(map(int, si().split()))
dots = sorted(dots)
lines = []
for _ in range(M):
  lines.append(list(map(int, si().split())))

def binary_min(start, end, target):
  while start <= end:
      idx = (start + end) // 2
      mid = dots[idx]
      if target > mid:
          start = idx + 1
      else:
          end = idx - 1
  return end + 1

def binary_max(start, end, target):
  while start <= end:
      idx = (start + end) // 2
      mid = dots[idx]
      ## 타겟이 중간보다 크거나 같을 때 -> 오른쪽으로 가야한다
      ## -> start를 중간+1로 바꿔준다.
      if target >= mid:
          start = idx + 1 
      ## 타겟이 중간보다 작을 때 -> 왼쪽으로 가야한다 
      ## -> end를 중간-1로 바꿔준다. 
      else:
          end = idx - 1
  return end

for l in lines:
  mini  = binary_min(0,len(dots)-1, l[0])
  max = binary_max(0,len(dots)-1, l[1])
  print(max-mini+1)

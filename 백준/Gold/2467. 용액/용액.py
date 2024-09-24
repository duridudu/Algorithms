import sys
input = sys.stdin.readline


n = int(input())
liquids = list(map(int, input().split()))
answer = []

start = 0
end = len(liquids)-1

while(start<end):
  res = liquids[start]+liquids[end]
  answer.append([abs(res), (liquids[start], liquids[end])])
  if res>=0 :
    end-=1
  else:
    start+=1
  
answer.sort(key=lambda x: (x[0]))

print(answer[0][1][0], answer[0][1][1])
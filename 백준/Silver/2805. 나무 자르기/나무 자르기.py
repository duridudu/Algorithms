import sys
input = sys.stdin.readline

def binary(trees):
  h=0
  start = 1
  end = max(trees)
  while(start<=end):
    h = (start+end)//2
    temp = 0
    t = []
    for tt in trees:
      if tt > h :
        t.append(tt-h)
    #print(temp, M)
    temp = sum(t)
    if temp >= M :
      ## h를 높여야 한다.
      start = h+1
    else:
      end = h-1
  return end

N,M = map(int, input().split())
trees = list(map(int, input().split()))
h = binary(trees)
print(h)
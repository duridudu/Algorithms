import sys
input = sys.stdin.readline

def binary(trees):
  h=0
  start = 1
  end = trees[-1]
  while(start<=end):
    h = (start+end)//2
    temp = 0
    for t in trees:
      if t > h :
        temp += (t-h)
    if temp >= M :
      ## h를 높여야 한다.
      start = h+1
    else:
      end = h-1
  return end

N,M = map(int, input().split())
trees = sorted(list(map(int, input().split())))
h = binary(trees)
print(h)
from itertools import permutations

n = int(input())
temp = list(range(1,10))
all = []
for p in permutations(temp, 3):
  all.append(p)

for _ in range(n):
  num, s, b = input().split()
  s,b=int(s), int(b)
  candidate = []
  for a in all :
    strike, ball = 0, 0
    for i in range(3):
      if int(num[i]) in a:
        if a[i] == int(num[i]):
          strike+=1
        else:
          ball+=1
    if strike == s and ball == b:
      candidate.append(a)
  all = candidate

print(len(all))
      
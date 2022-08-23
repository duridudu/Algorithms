n = int(input())
time = list(map(int, input().split()))
st = sorted(time)
res = 0
for i in range(len(st)):
    a = sum(st[:i+1])
    res += a
print(res)
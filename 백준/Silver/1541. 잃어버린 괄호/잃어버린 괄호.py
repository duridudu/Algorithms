a=input().split('-')
### 무조건 1번 인덱스부터는 마이너스거다
sums = []
for b in a:
    b = b.split('+')
    sum=0
    for c in b:
        sum += int(c)
    sums.append(sum)
res = 0
for i in range(1,len(sums)):
    res+=sums[i]
print(sums[0]-res)
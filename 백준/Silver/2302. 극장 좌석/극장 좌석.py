seat = int(input())
vip = int(input())
vips = []
for i in range(vip):
    vips.append(int(input()))

lst = []
cnt = 0

lst = [1,1,2]

for i in range(3,seat+1):
    lst.append(lst[i-1]+lst[i-2])

res = []
if vip >= 1 :
    start = 0
    for j in vips:
        res.append(lst[j-start-1])
        start = j # vip 자리
    res.append(lst[seat-start])
else:
    res.append(lst[seat])
    
ans = 1
for j in res : 
    ans *= j
    
print(ans)
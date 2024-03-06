n=int(input())
cards = sorted(list(map(int, input().split())))
m=int(input())
want = list(map(int, input().split()))
wants = sorted(want)

res = {}
for i in range(len(wants)):
    
    left = 0
    right = len(cards)
    target = wants[i]
    check = True
    while(left<right):
        mid = (left+right)//2
        if cards[mid] == target:
            check = False
            res[wants[i]] = 1
            break
        elif (cards[mid]<target):
            left = mid+1
        else:
            right = mid
    if check==True :
        res[wants[i]]  = 0

for w in want:
    print(res[w], end = " ")
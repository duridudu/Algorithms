from itertools import combinations, permutations
while(True):
    arr=list(map(int, input().split()))
    if arr[0]==0:
        break
    # print(arr[1:])
    combs=list(combinations(arr[1:], 6))
    for c in combs:
        print(*list(c))

    print()
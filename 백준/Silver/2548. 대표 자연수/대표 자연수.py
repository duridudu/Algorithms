from sys import stdin


n = int(stdin.readline())
arr = list(map(int, stdin.readline().split()))
arr.sort()

l, r = 0, n
res = int(1e9)
ans = max(arr)

while l <= r:
    mid = (l + r) // 2
    temp = sum([abs(x - arr[mid]) for x in arr])

    if temp <= res:
        ans = min(ans, arr[mid])
        res = temp
        r = mid - 1

    else:
        l = mid + 1

print(ans)
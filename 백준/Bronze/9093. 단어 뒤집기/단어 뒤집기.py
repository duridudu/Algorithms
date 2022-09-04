n = int(input())
for _ in range(n):
    st = list(input().split())
    for word in st:
        print(word[-1::-1], end=" ")
from itertools import combinations
L, K =map(int, input().split())
arr = list(input().split())
arr = sorted(arr)
for c in list(combinations(arr, L)):
    a=c.count("a")
    e=c.count("e")
    i=c.count("i")
    o=c.count("o")
    u=c.count("u")
    s = a+e+i+o+u

    if s>=1 and (L-2)>=s:
        print(''.join(list(c)))

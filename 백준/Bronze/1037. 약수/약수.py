num = int(input())
ns = list(map(int, input().split()))
if len(ns)==1:
    print(ns[0]*ns[0])
elif len(ns)==2:
    print(ns[0]*ns[1])
else:
    print(max(ns)*min(ns))
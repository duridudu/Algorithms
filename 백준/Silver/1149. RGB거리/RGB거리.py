n = int(input())
cities = []

calcur = [[0]*3 for _ in range(n)]
for i in range(n):
    cities.append(list(map(int, input().split())))

for i in range(n):
    #print(cities, calcur)
    calcur[i][0] = min(cities[i][0] + calcur[i-1][1], cities[i][0] + calcur[i-1][2])
    calcur[i][1] = min(cities[i][1] + calcur[i-1][0], cities[i][1] + calcur[i-1][2])
    calcur[i][2] = min(cities[i][2] + calcur[i-1][0], cities[i][2] + calcur[i-1][1])

print(min(calcur[n-1]))
n = int(input())
score = []
ans = 0
for _ in range(n):
    score.append(int(input()))

score.sort()


for i in range(n):
    if score[i] == (i+1) :
        continue
    else:
        ans+= abs(i+1-score[i])
print(ans)
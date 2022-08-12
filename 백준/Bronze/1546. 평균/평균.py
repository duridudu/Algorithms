num = int(input())
score = list(map(int, input().split()))
mx = max(score)
new = []

for s in score:
    new.append(s/mx*100)

print(sum(new)/num)
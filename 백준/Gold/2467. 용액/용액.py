# n=int(input())
# tops = list(map(int, input().split()))
# answer = []
# for i in range(len(tops)):
#     now = tops.pop()
#     idx = -1
#     #print("**********", i, tops)
#     while(True):
#         #print("before",idx, now, next)
#         if (idx*(-1) == len(tops)+1) or len(tops)==0:
#             answer.append(0)
#             break
#         next = tops[idx]
#         #print(idx, now, next)
#         if next > now:
#             answer.append(n+idx-i)
#             break
#         else :
#             idx-=1
#    # print(answer)
# answer.reverse()
# print(answer)

n = int(input()) # n=5

medicine = list(map(int,input().split()))

med = []
for m in medicine :
    med.append([abs(m), m])
med.sort(key=lambda x:x[0])
merge = []
for i in range(n-1):
    merge.append([i,abs(med[i][1]+med[i+1][1])])
merge.sort(key=lambda x:x[1])
idx = merge[0][0]
answer = [med[idx][1], med[idx+1][1]]
answer.sort()
print(*answer)
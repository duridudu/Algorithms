def solution(numbers):
    answer = ''
    sum_ = 0
    tmp = []
    for number in numbers:
        c = (str(number) * 4)[:4]
        length = len(str(number))
        tmp.append((c, length))
    tmp.sort(reverse=True)
    for (c, length) in tmp:
        sum_ += int(c)
        if sum_ == 0:
            return '0'
        answer += c[:length]
    return answer

# from collections import deque
# def solution(numbers):
#     answer = ''
#     new=[]
#     ## 무작권 앞자리 수 큰게 최고. 그 수 크기는 중요하지 x
#     for a in numbers:
#         new.append(list(str(a)))
#     numbers=sorted(new, key=lambda x: (-int(x[0])))
#     second=deque(numbers.copy())
#     print("초기 분해",second)
#     for i in range(len(numbers)):
#         if len(numbers[i])==1:
#             answer+=numbers[i][0]
#             second.popleft()
#             # print(answer)
#         else:
#             break
    
#     third=deque(second.copy())
#     if len(second)!=0:
#         second=sorted(second, key=lambda x:(-(int(x[0])), -(int(x[1]))))
#         for i in range(len(second)):
#             if len(second[i])==2:
#                 answer+=second[i][0]
#                 answer+=second[i][1]
#                 third.popleft()
#                 # print(answer)
#             else:
#                 break    
#     print("지금까지 답이야아아ㅏ아아악",answer)
#     print("나야아아아아아아아",list(third))
#     print(numbers)
#     ## 나도 ꫀꪜꪖ 라고 생각하긴햇다.................
    
#     return answer
import copy
def solution(name):
    moves = [-1, 1]
    nameList = list(name)
    # start = (nameList, index, count)
    def bfs(start):
        stack = [start]
        
        while stack:
            n = stack.pop()
            array, idx, cnt = n[0], n[1], n[2]
            cnt += min(ord(array[idx]) - 65, 91 - ord(array[idx])) # 아스키 코드값으로 변경 횟수 계산
            array[idx] = 'A'
            if array.count('A') == len(array): # 종료 시점
                return cnt
            for move in moves:
                new_array = copy.deepcopy(array) # array 주소 복사 서로 영향 안미치게
                new_idx = idx + move
                new_cnt = cnt + 1
                stack.insert(0, (new_array, new_idx, new_cnt))

    return bfs((nameList, 0, 0))

# from collections import deque
# import copy
# def solution(name):
#     answer = 0
#     target=len(name)
#     check=[False for i in range(len(name))]
    
#     # A : 65
#     # Z : 90
#     nums=list(map(ord, list(name)))
    
#     ## 좌우 이동
#     move=[-1,1]
#     # q=deque((nums, 0,0))
#     def bfs(start):
#         q=deque(start)
#         while (q):
#             hey=q.popleft()
#             array, idx, cnt=hey[0], hey[1], hey[2]
#             cnt+= min(ord(array[idx])-65, 91-ord(array[idx]))
#             array[idx]='A'
#             if array.count('A')==len(array):
#                 return cnt
#             for m in move:
#                 temp=copy.deepcopy(array)
#                 temp_idx=idx+m
#                 temp_cnt=cnt+1
#                 q.append((temp, temp_idx, temp_cnt))
#     bfs((list(name),0,0))
    
    
# #     for i in range(target):
# #         now=abs(nums[i]-65)
# #         print(now)
# #         if now>=14:
# #             answer+=(26-now)
# #         else:
# #             answer+=now
            
# #         ## 바꿨으면 다음 글자로 커서 옮기기   
# #         if i!=target-1:
# #             answer+=1
        
#     return answer